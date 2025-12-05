INSERT INTO APP_USER (ID, FIRST_NAME, LAST_NAME) VALUES
('00000000-0000-0000-0000-000000000000', 'Jake', 'Pasternak'),
('00000000-0000-0000-0000-000000000001', 'Emily', 'Reyes'),
('00000000-0000-0000-0000-000000000002', 'Marcus', 'Holloway'),
('00000000-0000-0000-0000-000000000003', 'Samantha', 'Cole'),
('00000000-0000-0000-0000-000000000004', 'Dylan', 'Bennett'),
('00000000-0000-0000-0000-000000000005', 'Laura', 'Chan'),
('00000000-0000-0000-0000-000000000006', 'Victor', 'Morales'),
('00000000-0000-0000-0000-000000000007', 'Tina', 'Fields'),
('00000000-0000-0000-0000-000000000008', 'Roger', 'Kim'),
('00000000-0000-0000-0000-000000000009', 'Alicia', 'Stone');

INSERT INTO ROLE (NAME, DESCRIPTION) VALUES
('OWNER', 'Full organizational control, including users, crews, jobs, and settings.'),
('ADMIN', 'Manager-level access to operations including jobs, crews, and customers.'),
('CREW_LEADER', 'Leads a field crew, manages job progress, and oversees crew tasks.'),
('CREW_MEMBER', 'Standard field worker with access to assigned jobs and updates.'),
('CUSTOMER', 'Customer portal user with access to job history and service requests.'),
('DISPATCHER', 'Schedules jobs, assigns crews, and manages the operational calendar.'),
('ESTIMATOR', 'Creates and modifies job estimates and pre-work documentation.'),
('ACCOUNTING', 'Handles invoices, payments, and financial summaries.'),
('MODERATOR', 'Reviews content such as job photos and comments for compliance.');

INSERT INTO APP_USER_ROLES (APP_USER_ID, ROLES_NAME) VALUES
('00000000-0000-0000-0000-000000000000', 'OWNER'),
('00000000-0000-0000-0000-000000000001', 'ADMIN'),
('00000000-0000-0000-0000-000000000002', 'CREW_LEADER'),
('00000000-0000-0000-0000-000000000003', 'CREW_MEMBER'),
('00000000-0000-0000-0000-000000000004', 'CREW_MEMBER'),
('00000000-0000-0000-0000-000000000005', 'CREW_MEMBER'),
('00000000-0000-0000-0000-000000000006', 'CREW_LEADER'),
('00000000-0000-0000-0000-000000000007', 'CREW_MEMBER'),
('00000000-0000-0000-0000-000000000008', 'CREW_MEMBER'),
('00000000-0000-0000-0000-000000000009', 'CREW_MEMBER');