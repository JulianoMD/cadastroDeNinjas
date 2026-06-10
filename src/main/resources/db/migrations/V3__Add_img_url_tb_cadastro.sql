-- Migration para adicionar a coluna de img_url na tabela de cadastro

ALTER TABLE tb_cadastro
ADD COLUMN img_url VARCHAR(255);