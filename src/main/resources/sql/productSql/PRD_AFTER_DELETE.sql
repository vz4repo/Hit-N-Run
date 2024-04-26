CREATE DEFINER = CURRENT_USER TRIGGER `homerunball`.`PRD_AFTER_DELETE` AFTER DELETE ON `PRD` FOR EACH ROW
BEGIN
	DELETE FROM pd_hist
    WHERE OLD.pd_id = pd_hist.pd_id;
    DELETE FROM pd_stat_hist
    WHERE OLD.pd_id = pd_stat_hist.pd_id;
END
