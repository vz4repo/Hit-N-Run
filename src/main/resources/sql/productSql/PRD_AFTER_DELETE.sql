CREATE DEFINER = CURRENT_USER TRIGGER `homerunball`.`PRD_AFTER_DELETE` AFTER DELETE ON `PRD` FOR EACH ROW
BEGIN
                                            /* prd 테이블에 있는 한 개의 행이 삭제될 때마다 */
	DELETE FROM pd_hist                     /* 이전의 제품ID와 pd_hist에 있는 제품ID가 동일한 행을 삭제한다. */
    WHERE OLD.pd_id = pd_hist.pd_id;
    DELETE FROM pd_stat_hist                /* 이전의 제품ID와 pd_stat_hist에 있는 제품ID가 동일한 행을 삭제한다. */
    WHERE OLD.pd_id = pd_stat_hist.pd_id;
END