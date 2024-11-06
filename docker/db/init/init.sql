-- -- sample_dbがなければ作成する
CREATE DATABASE if not exists sample_db;

-- sample_dbに切り替える
USE sample_db;

-- users テーブル作成
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    user_id VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    create_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- サンプルデータ登録
INSERT INTO users (user_name,user_id, email) VALUES
('テストユーザー1', 'USER_001', 'test-user1@example.com'),
('テストユーザー2', 'USER_002', 'test-user2@example.com'),
('テストユーザー3', 'USER_003', 'test-user3@example.com');
