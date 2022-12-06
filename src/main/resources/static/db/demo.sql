SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS transcations;




/* Create Tables */

CREATE TABLE transcations
(
	id int unsigned NOT NULL AUTO_INCREMENT,
	-- 1,依頼会社-現調
	-- 2,協力会社-管割図作成
	-- 3,製作会社-材料調達
	-- 4,検査機関-検査
	-- 5,検査機関-証明書発行
	-- 6,製作会社-出荷準備
	-- 7,協力会社-承認
	-- 8,依頼会社-承認
	-- 9,製作会社-出荷
	-- 10,協力会社-搬入・荷受確認
	-- 11,依頼会社-社内検査
	-- 12,依頼会社-立会検査
	status int NOT NULL COMMENT '1,依頼会社-現調
2,協力会社-管割図作成
3,製作会社-材料調達
4,検査機関-検査
5,検査機関-証明書発行
6,製作会社-出荷準備
7,協力会社-承認
8,依頼会社-承認
9,製作会社-出荷
10,協力会社-搬入・荷受確認
11,依頼会社-社内検査
12,依頼会社-立会検査',
	todo_company_tpye varchar(64) NOT NULL,
	created_by int,
	created_at datetime,
	updated_by int,
	updated_at datetime,
	PRIMARY KEY (id),
	UNIQUE (id)
);



