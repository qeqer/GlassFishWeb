USE `mydb`;

INSERT INTO `theater`(`theater_id`, `address`, `name`, `bio`) VALUES (1, "Tuda", "Tudaikin", "1990"), (2, "Suda", "Sudaikin", "1998"), (3, "Pushkina, Kolotushkina", "Volnov", "GREAT");
INSERT INTO `hall`(`hall_id`, `theater_id`, `num`) VALUES (1, 1, 1), (2, 1, 2), (3, 2, 1),(4, 3, 1);
INSERT INTO `places`(`place_id`, `hall_id`, `row_num`, `num`, `type`) VALUES (1, 1, 1, 1, 0), (2, 1, 1, 2, 1), (3, 1, 1, 3, 1),(4, 1, 1, 4, 2);
INSERT INTO `worker`(`worker_id`, `name`, `last_name`) VALUES (1, "Vasya", "Killer"), (2, "Alisa", "Vox"), (3, "Rubenshtern", "Morgenshtern");
INSERT INTO `scenario`(`scenario_id`, `Author`, `source_name`) VALUES (1, "Goblin", "Zhenya and karandash"), (2, "Zhenya", "Alisa and Vasya"), (3, "Homer", "Great Things");
INSERT INTO `shows`(`show_id`, `hall_id`, `dat`, `scenario_id`, `Duration`) VALUES (1, 1, "11.11.2001", 1, 90), (2, 2, "11.11.2019", 1, 90), (3, 4, "5.5.20019", 1, 45);
INSERT INTO `client` VALUES (1, "Olya", "Kechko", "admin"), (2, "Hen", "Rembr", "111");
INSERT INTO `place_for_sell` VALUES (1, 1000, 1, 1, 1), (2, 1000, 1, 1, 2), (3, 1500, 0, 1, 3),(4, 5000, 1, 2, 4);
INSERT INTO `booking` VALUES (1, 1, 1), (2, 2, 1), (3, 3, 1);
INSERT INTO `worker_in_show` VALUES (1, 1, 1, "C001_|-|4zK0R"), (2, 2, 1, "Main"), (3, 3, 3, "H4XX0RX");
INSERT INTO `worker_in_theater` VALUES (1, 1, 1, "C001_|-|4zK0R"), (2, 2, 2, "Main"), (3, 3, 3, "H4XX0RX");