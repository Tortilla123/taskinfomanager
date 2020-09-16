
insert into EMPLOYEE(EMP_ID, CID, EMP_NAME, ACCESS, GROUP_ID, MAINT_ID, MAINT_TS) VALUES ( 141896, 'C802133', 'Shreekanth', 'A', 'IntermodalEDO', 141896, '2019-08-03 19:00:00' );
insert into GROUPS(GROUP_ID, GROUP_NAME, MAINT_ID, MAINT_TS) values ( 'INEDMF', 'IntermodalEDO', 141896, '2019-08-13 19:00:00' );
insert into APPLICATIONS(app_name, manager_name, area, maint_id, maint_ts) values ('Oasis', 'Donn Dunn', 'EDO', 141896, '2019-08-13 19:00:01');
insert into TASKS(app_name, group_id, incident_id, incident_type, summary, emp_id, submit_date, closed_date, impact, resolution, res_cate_tier_1, status, responded_date, res_cate_tier_3, target_date, maint_id, maint_ts) values
                 ('Oasis', 'IntermodalJava', 'INC000002923152', 'L2', 'Oasis Process Needs to be Restarted', 50530, '2019-08-11 22:38:59', '2019-08-11 22:47:53', 'HIGH', 'VM Restarted', 'Application Sustainment', 'Closed', '2019-08-11 22:40:14', 'Analysis', '2019-08-11 22:40:14', 141896, '2019-08-13 19:00:00'),
                 ('Oasis', 'IntermodalJava', 'INC000002923153', 'L3', 'Oasis Process Needs to be Restarted', 9090909, '2019-08-11 22:38:59', '2019-08-11 22:47:53', 'HIGH', 'VM Restarted', 'Application Sustainment', 'Open', '2019-08-11 22:40:14', 'Analysis', '2019-08-11 22:40:14', 141896, '2019-08-13 19:00:00');
