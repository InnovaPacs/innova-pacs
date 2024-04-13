
INSERT INTO users (id, email, password, status)
VALUES
('1', 'user1@example.com', 'password1', 'active'),
('2', 'user2@example.com', 'password2', 'active'),
('3', 'user3@example.com', 'password3', 'active'),
('4', 'user4@example.com', 'password4', 'active'),
('5', 'user5@example.com', 'password5', 'active'),
('6', 'user6@example.com', 'password6', 'active'),
('7', 'user7@example.com', 'password7', 'active'),
('8', 'user8@example.com', 'password8', 'active');


INSERT INTO medical_offices (id, name, image, address, city, state, postal_code, country)
VALUES
('1', 'Medical Office 1', 'image1.jpg', '123 Main St', 'City1', 'State1', '12345', 'Country1'),
('2', 'Medical Office 2', 'image2.jpg', '456 Elm St', 'City2', 'State2', '54321', 'Country2'),
('3', 'Medical Office 3', 'image3.jpg', '789 Oak St', 'City3', 'State3', '98765', 'Country3');

INSERT INTO patients (id, document_id, ssn, emergency_contact, notes, user_id, medical_office_id, phone_number, address, city, state, postal_code, country, first_name, last_name, date_of_birth, gender, marital_status)
VALUES
('1', 'DOC123', 'SSN123', 'Emergency Contact 1', 'Notes for patient 1', '1', '1', '123456789', '123 Main St', 'City1', 'State1', '12345', 'Country1', 'John', 'Doe', '1990-01-01', 'Male', 'Single'),
('2', 'DOC456', 'SSN456', 'Emergency Contact 2', 'Notes for patient 2', '2', '1', '987654321', '456 Elm St', 'City2', 'State2', '54321', 'Country2', 'Jane', 'Smith', '1985-05-15', 'Female', 'Married'),
('3', 'DOC789', 'SSN789', 'Emergency Contact 3', 'Notes for patient 3', '3', '2', '555555555', '789 Oak St', 'City3', 'State3', '98765', 'Country3', 'Alice', 'Johnson', '1978-09-20', 'Female', 'Divorced'),
('4', 'DOC012', 'SSN012', 'Emergency Contact 4', 'Notes for patient 4', '4', '2', '444444444', '101 Pine St', 'City4', 'State4', '12398', 'Country4', 'Bob', 'Williams', '1995-03-10', 'Male', 'Single'),
('5', 'DOC345', 'SSN345', 'Emergency Contact 5', 'Notes for patient 5', '5', '2', '333333333', '202 Maple St', 'City5', 'State5', '54321', 'Country5', 'David', 'Brown', '1982-07-04', 'Male', 'Married');




INSERT INTO physicians (id, document_id, ssn, user_id, phone_number, address, city, state, postal_code, country, first_name, last_name, date_of_birth, gender, marital_status)
VALUES
('1', 'DOC123', 'SSN123', '6', '222222222', '303 Cedar St', 'City6', 'State6', '78654', 'Country6', 'Mary', 'Miller', '1989-12-25', 'Female', 'Single'),
('2', 'DOC456', 'SSN456', '7', '111111111', '404 Walnut St', 'City7', 'State7', '98712', 'Country7', 'Michael', 'Davis', '1973-11-30', 'Male', 'Widowed'),
('3', 'DOC789', 'SSN789', '8', '999999999', '505 Birch St', 'City8', 'State8', '56789', 'Country8', 'Emily', 'Taylor', '1998-04-18', 'Female', 'Married');


INSERT INTO physician_medical_office (physician_id, medical_office_id)
VALUES
('1', '1'),
('1', '2'),
('2', '1'),
('3', '3');


INSERT INTO studies (id, patient_id, physician_id, study_date, modality, study_type, study_description, study_results)
VALUES
('1', '1', '1', '2024-04-10', 'MRI', 'Brain Scan', 'MRI of Brain', 'Normal'),
('2', '2', '2', '2024-04-12', 'X-ray', 'Chest X-ray', 'X-ray of Chest', 'No abnormalities'),
('3', '3', '3', '2024-04-15', 'Ultrasound', 'Abdominal Ultrasound', 'Ultrasound of Abdomen', 'Appendicitis'),
('4', '4', '4', '2024-04-18', 'CT Scan', 'Head CT Scan', 'CT Scan of Head', 'Fracture detected');


INSERT INTO appointments (id, appointment_date, appointment_time, purpose, status, control_number, created_at, updated_at, patient_id, physician_id, medical_office_id, study_id)
VALUES
('1', '2024-04-10', '10:00:00', 'General check-up', 'Scheduled', 'CN123', '2024-04-09', '2024-04-09', '1', '1', '1', '1'),
('2', '2024-04-12', '11:30:00', 'X-ray examination', 'Scheduled', 'CN456', '2024-04-11', '2024-04-11', '2', '2', '1', '2'),
('3', '2024-04-15', '09:00:00', 'Abdominal pain', 'Scheduled', 'CN789', '2024-04-14', '2024-04-14', '3', '3', '3', '3'),
('4', '2024-04-18', '14:00:00', 'Head injury', 'Scheduled', 'CN012', '2024-04-17', '2024-04-17', '4', '3', '2', '4');
