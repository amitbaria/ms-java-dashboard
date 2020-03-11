DROP PROCEDURE IF EXISTS `P7_DASHBOARD_V1.1_MD_Schema_01`;

DELIMITER //

CREATE PROCEDURE `P7_DASHBOARD_V1.1_MD_Schema_01`()
BEGIN


	SET @VersionNumber = 'P7_DAS_MD_1.1_01';
	IF (SELECT NOT EXISTS(SELECT * FROM p7_com_version WHERE version_number = @VersionNumber))
	THEN
		
		INSERT INTO `p7_widget_categories` (`id`, `code`, `label`, `type`, `height`, `width`, `bar_chart`, `column_chart`, `line_chart`, `pie_chart`, `area_chart`, `is_live`, `status`) VALUES
		(1, 'COUNTER_CPE', 'Total CPE Counter', '1', 3, 3, 0, 0, 0, 0, 0, 0, 0),
		(2, 'COUNTER_VNF', 'VNF Counter', '1', 3, 3, 0, 0, 0, 0, 0, 0, 0),
		(3, 'COUNTER_ALERTS', 'Critical Alerts Counter', '1', 3, 3, 0, 0, 0, 0, 0, 0, 0),
		(4, 'COUNTER_NOTIFICATION', 'Notification Counter', '1', 3, 3, 0, 0, 0, 0, 0, 0, 0),
		(5, 'COUNTER_USER', 'User Counter', '1', 3, 3, 0, 0, 0, 0, 0, 0, 0),
		(6, 'ALERTS_NETWORK_THRESHOLD', 'Network Threshold Trends', '2', 8, 8, 0, 0, 1, 0, 1, 0, 0),
		(7, 'ALERT_CPU_UTILIZATION_THRESHOLD', 'CPU Utilization Threshold Trends', '2', 8, 8, 0, 0, 1, 0, 1, 0, 0),
		(8, 'ALERT_MEMORY_UTILIZATION_THRESHOLD', 'Memory Utilization Threshold Trends', '2', 8, 8, 0, 0, 1, 0, 1, 0, 0),
		(9, 'ALERT_DISK_UTILIZATION_THRESHOLD', 'Disk Utilization Threshold Trends', '2', 8, 8, 0, 0, 1, 0, 1, 0, 0),
		(10, 'STATS_NETWORK_BY_SITE', 'CPE Statistics By Site', '4', 8, 8, 0, 0, 0, 0, 0, 0, 0),
		(11, 'STATS_CPU', 'CPU Statistics ', '4', 8, 8, 0, 0, 1, 0, 1, 0, 1),
		(12, 'STATS_MEMORY', 'Memory Statistics', '4', 8, 8, 0, 0, 1, 0, 1, 0, 1),
		(13, 'STATS_PORT', 'Port Statistics ', '4', 8, 8, 0, 0, 1, 0, 1, 0, 1),
		(14, 'STATS_LINK', 'Link Statistics ', '4', 8, 8, 0, 0, 1, 0, 1, 0, 1),
		(15, 'HEALTH_NETWORK', 'Live Network Trends', '3', 8, 8, 0, 0, 1, 0, 1, 1, 1),
		(16, 'HEALTH_CPU', 'Live CPU Utilization Trends', '3', 8, 8, 0, 0, 1, 0, 1, 1, 1),
		(17, 'HEALTH_MEMORY', 'Live Memory Utilization Trends', '3', 8, 8, 0, 0, 1, 0, 1, 1, 1),
		(18, 'HEALTH_DISK', 'Live Disk Utilization Trends', '3', 8, 8, 0, 0, 1, 0, 1, 1, 1),
		(19, 'HEALTH_PORT', 'Live Port Utilization Trends', '3', 8, 8, 0, 0, 1, 0, 1, 1, 1),
		(20, 'HEALTH_LINK', 'Link Status', '3', 8, 8, 0, 0, 1, 0, 1, 0, 1),
		(21, 'TRENDS_NETWORK_OVER_LINKS', 'Network Traffic Trends over Links', '5', 8, 8, 0, 0, 1, 0, 1, 0, 1),
		(22, 'TRENDS_CPU', 'CPU Utilization Trends over Time', '5', 8, 8, 0, 0, 1, 0, 1, 0, 1),
		(23, 'TRENDS_MEMORY', 'Memory Utilization Trends over Time', '5', 8, 8, 0, 0, 1, 0, 1, 0, 1),
		(24, 'TRENDS_DISK', 'Disk Utilization Trends over Time', '5', 8, 8, 0, 0, 1, 0, 1, 0, 1),
		(25, 'TRENDS_PORT', 'Port Traffic Trends over Time', '5', 8, 8, 0, 0, 1, 0, 1, 0, 1),
		(26, 'TRENDS_LINK', 'Links Status Trends over Time', '5', 8, 8, 0, 0, 1, 0, 1, 0, 1),
		(27, 'CPE_MAP', 'CPE Map', '6', 10, 17, 0, 0, 0, 0, 0, 0, 0),
		(28, 'INSIGHTS', 'Insights', '6', 12, 8, 0, 0, 0, 0, 0, 0, 0);
		
		
		INSERT INTO `p7_widget_filters` (`id`, `filter_name`) VALUES
		(1, 'filter_date_range'),
		(2, 'filter_cpe'),
		(3, 'filter_multiple_cpe'),
		(4, 'filter_cpe_status'),
		(5, 'filter_vnf'),
		(6, 'filter_vnf_status'),
		(7, 'filter_port'),
		(8, 'filter_link'),
		(9, 'filter_link_status'),
		(10, 'filter_user_type'),
		(11, 'filter_location'),
		(12, 'filter_multiple_status'),
		(13, 'filter_alert_types');
		
		
		INSERT INTO `p7_widget_category_filters` (`id`, `widget_filter_id`, `widget_category_id`, `required`) VALUES
		(1, 4, 1, 1),
		(2, 3, 2, 1),
		(3, 6, 2, 1),
		(4, 3, 3, 1),
		(5, 3, 4, 1),
		(6, 10, 5, 1),
		(7, 2, 6, 1),
		(8, 7, 6, 1),
		(9, 2, 7, 1),
		(10, 5, 7, 1),
		(11, 2, 8, 1),
		(12, 5, 8, 1),
		(13, 2, 9, 1),
		(14, 5, 9, 1),
		(15, 11, 10, 1),
		(16, 2, 11, 1),
		(17, 5, 11, 1),
		(18, 5, 12, 1),
		(19, 2, 12, 1),
		(20, 1, 13, 1),
		(21, 2, 13, 1),
		(22, 7, 13, 1),
		(23, 2, 15, 1),
		(24, 7, 15, 1),
		(25, 2, 16, 1),
		(26, 5, 16, 1),
		(27, 2, 17, 1),
		(28, 5, 17, 1),
		(29, 2, 18, 1),
		(30, 5, 18, 1),
		(31, 2, 19, 1),
		(32, 7, 19, 1),
		(33, 2, 20, 1),
		(34, 8, 20, 1),
		(35, 2, 21, 1),
		(36, 8, 21, 1),
		(37, 2, 22, 1),
		(38, 5, 22, 1),
		(39, 2, 23, 1),
		(40, 5, 23, 1),
		(41, 2, 24, 1),
		(42, 5, 24, 1),
		(43, 2, 25, 1),
		(44, 7, 25, 1),
		(45, 2, 26, 1),
		(46, 8, 26, 1),
		(47, 1, 14, 1),
		(48, 2, 14, 1),
		(49, 8, 14, 1),
		(50, 1, 6, 1),
		(51, 1, 7, 1),
		(52, 1, 8, 1),
		(53, 1, 9, 1),
		(54, 1, 11, 1),
		(55, 1, 12, 1),
		(56, 1, 20, 1),
		(57, 1, 21, 1),
		(58, 1, 22, 1),
		(59, 1, 23, 1),
		(60, 1, 24, 1),
		(61, 1, 25, 1),
		(62, 1, 26, 1),
		(63, 12, 27, 1),
		(64, 3, 28, 1),
		(65, 13, 28, 1);


		

		
		INSERT IGNORE INTO p7_com_version(version_number,version_deployment_date) VALUES(@VersionNumber,CURRENT_TIMESTAMP);
	ELSE 
	SELECT CONCAT('Version ',@VersionNumber,' Already Deployed...') as '';
	END IF;

END//


DELIMITER ;