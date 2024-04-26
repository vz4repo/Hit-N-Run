CREATE DEFINER = CURRENT_USER TRIGGER `homerunball`.`PRD_AFTER_UPDATE` AFTER UPDATE ON `PRD` FOR EACH ROW
BEGIN
	DECLARE existing_prd_hist_count INT;        /* 제품의 변경 이력이 몇 개인지 저장하는 변수 */
    DECLARE existing_prd_stat_hist_count INT;   /* 제품의 상태가 변경된 이력이 몇 개인지 저장하는 변수 */
    DECLARE first_reg_dt DATETIME;              /* 제품의 첫 번째 등록일을 저장하는 변수 */
    
    /* 이미 해당 제품의 이력이 있는지 확인 */
    SELECT COUNT(*) INTO existing_prd_hist_count FROM pd_hist WHERE pd_id = OLD.pd_id;
    
                                                /* 제품의 이력이 없는 경우 */
    IF existing_prd_hist_count = 0 THEN
        SET first_reg_dt = NOW();
    ELSE                                        /* 제품의 이력이 있는 경우, 첫 등록일 가져오기 */
        SELECT frst_reg_dt INTO first_reg_dt FROM pd_hist WHERE pd_id = OLD.pd_id LIMIT 1;
    END IF;

	/* 이전의 제품명과 새로운 제품명이 일치하지 않는다면 제품 내용 변경 항목은 제품명, pd_bf는 이전 제품명, pd_af는 이후 제품명 */
	IF old.pd_name <> new.pd_name THEN
		INSERT INTO pd_hist(pd_id, pd_cntn_cng_item_cd, pd_bf, pd_af, frst_reg_dt, frst_reg_id, last_mod_dt, last_mod_id) 
		VALUES(old.pd_id, '제품명', old.pd_name, new.pd_name, first_reg_dt, 'ikjun', NOW(), 'ikjun');

    /* 이전의 모델명과 새로운 모델명이 일치하지 않는다면 제품 내용 변경 항목은 모델명, pd_bf는 이전 모델명, pd_af는 이후 모델명 */
    ELSEIF old.mdl_name <> new.mdl_name THEN
		INSERT INTO pd_hist(pd_id, pd_cntn_cng_item_cd, pd_bf, pd_af, frst_reg_dt, frst_reg_id, last_mod_dt, last_mod_id) 
		VALUES(old.pd_id, '모델명', old.mdl_name, new.mdl_name, first_reg_dt, 'ikjun', NOW(), 'ikjun');
	
    ELSEIF old.pd_ad_cmt <> new.pd_ad_cmt THEN
		INSERT INTO pd_hist(pd_id, pd_cntn_cng_item_cd, pd_bf, pd_af, frst_reg_dt, frst_reg_id, last_mod_dt, last_mod_id) 
		VALUES(old.pd_id, '홍보문구', old.pd_ad_cmt, new.pd_ad_cmt, first_reg_dt, 'ikjun', NOW(), 'ikjun');
	
    ELSEIF old.pd_smr_dsc <> new.pd_smr_dsc THEN
		INSERT INTO pd_hist(pd_id, pd_cntn_cng_item_cd, pd_bf, pd_af, frst_reg_dt, frst_reg_id, last_mod_dt, last_mod_id) 
		VALUES(old.pd_id, '요약설명', old.pd_smr_dsc, new.pd_smr_dsc, first_reg_dt, 'ikjun', NOW(), 'ikjun');
	
    ELSEIF old.pd_det_dsc <> new.pd_det_dsc THEN
		INSERT INTO pd_hist(pd_id, pd_cntn_cng_item_cd, pd_bf, pd_af, frst_reg_dt, frst_reg_id, last_mod_dt, last_mod_id) 
		VALUES(old.pd_id, '상세설명', old.pd_det_dsc, new.pd_det_dsc, first_reg_dt, 'ikjun', NOW(), 'ikjun');
	
    ELSEIF old.min_od_qty <> new.min_od_qty THEN
		INSERT INTO pd_hist(pd_id, pd_cntn_cng_item_cd, pd_bf, pd_af, frst_reg_dt, frst_reg_id, last_mod_dt, last_mod_id) 
		VALUES(old.pd_id, '최소주문', old.min_od_qty, new.min_od_qty, first_reg_dt, 'ikjun', NOW(), 'ikjun');
	
    ELSEIF old.max_od_qty <> new.max_od_qty THEN
		INSERT INTO pd_hist(pd_id, pd_cntn_cng_item_cd, pd_bf, pd_af, frst_reg_dt, frst_reg_id, last_mod_dt, last_mod_id) 
		VALUES(old.pd_id, '최대주문', old.max_od_qty, new.max_od_qty, first_reg_dt, 'ikjun', NOW(), 'ikjun');
	
    ELSEIF old.pd_is_show <> new.pd_is_show THEN
		INSERT INTO pd_hist(pd_id, pd_cntn_cng_item_cd, pd_bf, pd_af, frst_reg_dt, frst_reg_id, last_mod_dt, last_mod_id) 
		VALUES(old.pd_id, '노출여부', old.pd_is_show, new.pd_is_show, first_reg_dt, 'ikjun', NOW(), 'ikjun');
	
    ELSEIF old.sls_strt_dt <> new.sls_strt_dt THEN
		INSERT INTO pd_hist(pd_id, pd_cntn_cng_item_cd, pd_bf, pd_af, frst_reg_dt, frst_reg_id, last_mod_dt, last_mod_id) 
		VALUES(old.pd_id, '판매시작', old.sls_strt_dt, new.sls_strt_dt, first_reg_dt, 'ikjun', NOW(), 'ikjun');
	
    ELSEIF old.hit_cnt <> new.hit_cnt THEN
		INSERT INTO pd_hist(pd_id, pd_cntn_cng_item_cd, pd_bf, pd_af, frst_reg_dt, frst_reg_id, last_mod_dt, last_mod_id) 
		VALUES(old.pd_id, '조회수', old.hit_cnt, new.hit_cnt, first_reg_dt, 'ikjun', NOW(), 'ikjun');
	
    ELSEIF old.rvw_cnt <> new.rvw_cnt THEN
		INSERT INTO pd_hist(pd_id, pd_cntn_cng_item_cd, pd_bf, pd_af, frst_reg_dt, frst_reg_id, last_mod_dt, last_mod_id) 
		VALUES(old.pd_id, '리뷰수', old.rvw_cnt, new.rvw_cnt, first_reg_dt, 'ikjun', NOW(), 'ikjun');
	
    ELSEIF old.wish_cnt <> new.wish_cnt THEN
		INSERT INTO pd_hist(pd_id, pd_cntn_cng_item_cd, pd_bf, pd_af, frst_reg_dt, frst_reg_id, last_mod_dt, last_mod_id) 
		VALUES(old.pd_id, '좋아요수', old.wish_cnt, new.wish_cnt, first_reg_dt, 'ikjun', NOW(), 'ikjun');
    
    ELSEIF old.pd_chr_cd <> new.pd_chr_cd THEN
		INSERT INTO pd_hist(pd_id, pd_cntn_cng_item_cd, pd_bf, pd_af, frst_reg_dt, frst_reg_id, last_mod_dt, last_mod_id) 
		VALUES(old.pd_id, '제품특성', old.pd_chr_cd, new.pd_chr_cd, first_reg_dt, 'ikjun', NOW(), 'ikjun');
	END IF;
    
    -- 이미 해당 제품 상태의 이력이 있는지 확인
    SELECT COUNT(*) INTO existing_prd_stat_hist_count FROM pd_stat_hist WHERE pd_id = OLD.pd_id;
    
	-- 제품 상태의 이력이 없는 경우
    IF existing_prd_stat_hist_count = 0 THEN
        SET first_reg_dt = NOW();
    ELSE
    -- 제품 상태의 이력이 있는 경우, 첫 등록일 가져오기
        SELECT frst_reg_dt INTO first_reg_dt FROM pd_stat_hist WHERE pd_id = OLD.pd_id ORDER BY frst_reg_dt LIMIT 1;
    END IF;
    
    IF old.pd_stat_hist_cd <> new.pd_stat_hist_cd THEN
		INSERT INTO pd_stat_hist(pd_id, pd_stat_hist_cd, frst_reg_dt, frst_reg_id, last_mod_dt, last_mod_id) 
		VALUES(old.pd_id, new.pd_stat_hist_cd, first_reg_dt, 'ikjun', NOW(), 'ikjun');
	END IF;
    
END