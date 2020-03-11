DROP PROCEDURE IF EXISTS `P7_DASHBOARD_V1.0_DB_Schema_01`;

DELIMITER //

CREATE PROCEDURE `P7_DASHBOARD_V1.0_DB_Schema_01`()
BEGIN
	# VersionControl Table to check Script version and deployment.
	CREATE TABLE IF NOT EXISTS p7_com_version
	(
		version_id 					INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
		version_number 				VARCHAR(20) NOT NULL,
		version_deployment_date 	DATETIME NOT NULL
	)COLLATE='utf8_general_ci';

	SET @VersionNumber = 'P7_DAS_DB_1.0_01';
	IF (SELECT NOT EXISTS(SELECT * FROM p7_com_version WHERE version_number = @VersionNumber))
	THEN
		

		CREATE TABLE IF NOT EXISTS `p7_dashboard` 
		(
			`id` 					INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
			`name` 					VARCHAR(255) DEFAULT NULL,
			`code` 					VARCHAR(50) DEFAULT NULL,
			`is_primary` 			VARCHAR(50) DEFAULT NULL,
			`user_id` 				VARCHAR(50) DEFAULT NULL,
			`is_deleted` 			INT(1) DEFAULT '0',
			`created_on` 			DATETIME DEFAULT CURRENT_TIMESTAMP,
			`modified_on` 			DATETIME DEFAULT NULL,
			`is_default` 			VARCHAR(50) DEFAULT '0'
		);


		CREATE TABLE IF NOT EXISTS `p7_widget` 
		(
			`id` 					int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
			`widget_category_id` 	int(11) DEFAULT NULL,
			`dashboard_id` 			int(11) DEFAULT NULL,
			`x_pos` 				decimal(10,0) DEFAULT NULL,
			`y_pos` 				decimal(10,0) DEFAULT NULL,
			`height` 				decimal(10,0) DEFAULT NULL,
			`width` 				decimal(10,0) DEFAULT NULL,
			`label_name` 			varchar(40) DEFAULT NULL,
			`is_deleted` 			int(1) DEFAULT '0',
			`graph_type` 			varchar(50) DEFAULT NULL,
			`dragAndDrop` 			tinyint(1) DEFAULT NULL,
			`resizable` 			tinyint(1) DEFAULT NULL,
			`refresh_interval` 		int(11) DEFAULT '0',
			`billing_account_uuid` 	varchar(255) DEFAULT NULL
		);
		

		CREATE TABLE IF NOT EXISTS `p7_widget_categories` 
		(
			`id` 					int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
			`code` 					varchar(150) DEFAULT NULL,
			`label` 				varchar(255) DEFAULT NULL,
			`type` 					varchar(50) DEFAULT NULL,
			`height` 				int(11) DEFAULT NULL,
			`width` 				int(11) DEFAULT NULL,
			`bar_chart` 			int(1) DEFAULT NULL,
			`column_chart` 			int(1) DEFAULT NULL,
			`line_chart` 			int(1) DEFAULT NULL,
			`pie_chart` 			int(1) DEFAULT NULL,
			`area_chart` 			int(1) DEFAULT NULL,
			`is_live` 				int(1) DEFAULT NULL,
			`status` 				int(11) DEFAULT '0'
		);


		CREATE TABLE IF NOT EXISTS `p7_widget_category_filters` 
		(
			`id` 					int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
			`widget_filter_id` 		int(11) DEFAULT NULL,
			`widget_category_id` 	int(11) DEFAULT NULL,
			`required` 				int(1) DEFAULT NULL
		);

		
		CREATE TABLE IF NOT EXISTS `p7_widget_filters` 
		(
			`id` 					int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
			`filter_name` 			varchar(255) DEFAULT NULL
		);
		
		
		CREATE TABLE IF NOT EXISTS `p7_widget_payload` 
		(
			`id` 					int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
			`widget_id` 			varchar(255) DEFAULT NULL,
			`payload_key` 			varchar(255) DEFAULT NULL,
			`payload_value` 		varchar(255) DEFAULT NULL
		);

	INSERT IGNORE INTO p7_com_version(version_number,version_deployment_date) VALUES(@VersionNumber,CURRENT_TIMESTAMP);
	ELSE 
	SELECT CONCAT('Version ',@VersionNumber,' Already Deployed...') as '';
	END IF;

END//


DELIMITER ;


