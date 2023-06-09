CREATE TABLE BRAND (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE PRICES (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  brand_id BIGINT NOT NULL,
  FOREIGN KEY (brand_id) REFERENCES BRAND(id),
  start_date DATETIME NOT NULL,
  end_date DATETIME NOT NULL,
  price_list BIGINT NOT NULL,
  product_id BIGINT NOT NULL,
  priority INT NOT NULL,
  price DECIMAL(19,2) NOT NULL,
  curr VARCHAR(3) NOT NULL
);