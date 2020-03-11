DROP PROCEDURE IF EXISTS `P7_DASHBOARD_V1.2_DB_Schema_01`;

DELIMITER //

CREATE PROCEDURE `P7_DASHBOARD_V1.2_DB_Schema_01`()
BEGIN
	

	SET @VersionNumber = 'P7_DAS_DB_1.2_01';
	IF (SELECT NOT EXISTS(SELECT * FROM p7_com_version WHERE version_number = @VersionNumber))
	THEN
		

		IF NOT EXISTS (SELECT * FROM information_schema.TABLE_CONSTRAINTS WHERE table_schema = DATABASE()  
					   AND  Table_Name = 'p7_widget' AND Constraint_Name ='fk_p7_widget_a')
		THEN
			ALTER TABLE p7_widget ADD CONSTRAINT fk_p7_widget_a
			FOREIGN KEY (dashboard_id) REFERENCES p7_dashboard(`id`);
		END IF;
		
		
		IF NOT EXISTS (SELECT * FROM information_schema.TABLE_CONSTRAINTS WHERE table_schema = DATABASE()  
					   AND  Table_Name = 'p7_widget' AND Constraint_Name ='fk_p7_widget_b')
		THEN
			ALTER TABLE p7_widget ADD CONSTRAINT fk_p7_widget_b
			FOREIGN KEY (widget_category_id) REFERENCES p7_widget_categories(`id`);
		END IF;
		
		
		IF EXISTS(
			SELECT * FROM information_schema.columns
			WHERE Table_Schema = DATABASE() AND Table_Name = 'p7_widget_payload'
			AND Column_Name = 'widget_id' AND DATA_TYPE='VARCHAR'
		)
		THEN
			ALTER TABLE `p7_widget_payload` CHANGE COLUMN `widget_id` `widget_id` INT(11) DEFAULT NULL;
		END IF;
		
		
		IF NOT EXISTS (SELECT * FROM information_schema.TABLE_CONSTRAINTS WHERE table_schema = DATABASE()  
					   AND  Table_Name = 'p7_widget_payload' AND Constraint_Name ='fk_p7_widget_payload_a')
		THEN
			ALTER TABLE p7_widget_payload ADD CONSTRAINT fk_p7_widget_payload_a
			FOREIGN KEY (widget_id) REFERENCES p7_widget(`id`);
		END IF;
		
		
		IF NOT EXISTS (SELECT * FROM information_schema.TABLE_CONSTRAINTS WHERE table_schema = DATABASE()  
					   AND  Table_Name = 'p7_widget_category_filters' AND Constraint_Name ='fk_p7_widget_category_filters_a')
		THEN
			ALTER TABLE p7_widget_category_filters ADD CONSTRAINT fk_p7_widget_category_filters_a
			FOREIGN KEY (widget_filter_id) REFERENCES p7_widget_filters(`id`);
		END IF;
		
		
		IF NOT EXISTS (SELECT * FROM information_schema.TABLE_CONSTRAINTS WHERE table_schema = DATABASE()  
					   AND  Table_Name = 'p7_widget_category_filters' AND Constraint_Name ='fk_p7_widget_category_filters_b')
		THEN
			ALTER TABLE p7_widget_category_filters ADD CONSTRAINT fk_p7_widget_category_filters_b
			FOREIGN KEY (widget_category_id) REFERENCES p7_widget_categories(`id`);
		END IF;
		

	INSERT IGNORE INTO p7_com_version(version_number,version_deployment_date) VALUES(@VersionNumber,CURRENT_TIMESTAMP);
	ELSE 
	SELECT CONCAT('Version ',@VersionNumber,' Already Deployed...') as '';
	END IF;

END//


DELIMITER ;


