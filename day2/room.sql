CREATE TABLE room(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20),
    admin_id BIGINT
);
INSERT INTO `room` VALUES (1, '房间1', 2);
INSERT INTO `room` VALUES (2, '房间2', 4);
