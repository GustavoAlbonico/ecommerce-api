--SE DER ERRO AO INICIAR EXCLUI O BANCO DE DADOS E CRIAR DENOVO store-pandora

--Usuario

INSERT INTO usuario (login, senha)
VALUES ('alice', '$2a$10$KlP8kY1aoizCkKQCuiq1u.4stBMVYCNMlNhvHBIOxSH4bY4lZ81MC')
ON conflict DO nothing;

INSERT INTO usuario (login, senha)
VALUES ('bob', '$2a$10$KlP8kY1aoizCkKQCuiq1u.4stBMVYCNMlNhvHBIOxSH4bY4lZ81MC')
ON conflict DO nothing;

INSERT INTO usuario (login, senha)
VALUES ('charlie', '$2a$10$KlP8kY1aoizCkKQCuiq1u.4stBMVYCNMlNhvHBIOxSH4bY4lZ81MC')
ON conflict DO nothing;

INSERT INTO usuario (login, senha)
VALUES ('diana', '$2a$10$KlP8kY1aoizCkKQCuiq1u.4stBMVYCNMlNhvHBIOxSH4bY4lZ81MC')
ON conflict DO nothing;

INSERT INTO usuario (login, senha)
VALUES ('elena', '$2a$10$KlP8kY1aoizCkKQCuiq1u.4stBMVYCNMlNhvHBIOxSH4bY4lZ81MC')
ON conflict DO nothing;

INSERT INTO usuario (login, senha)
VALUES ('frank', '$2a$10$KlP8kY1aoizCkKQCuiq1u.4stBMVYCNMlNhvHBIOxSH4bY4lZ81MC')
ON conflict DO nothing;

INSERT INTO usuario (login, senha)
VALUES ('gina', '$2a$10$KlP8kY1aoizCkKQCuiq1u.4stBMVYCNMlNhvHBIOxSH4bY4lZ81MC')
ON conflict DO nothing;

INSERT INTO usuario (login, senha)
VALUES ('harry', '$2a$10$KlP8kY1aoizCkKQCuiq1u.4stBMVYCNMlNhvHBIOxSH4bY4lZ81MC')
ON conflict DO nothing;

INSERT INTO usuario (login, senha)
VALUES ('irene', '$2a$10$KlP8kY1aoizCkKQCuiq1u.4stBMVYCNMlNhvHBIOxSH4bY4lZ81MC')
ON conflict DO nothing;

INSERT INTO usuario (login, senha)
VALUES ('jack', '$2a$10$KlP8kY1aoizCkKQCuiq1u.4stBMVYCNMlNhvHBIOxSH4bY4lZ81MC')
ON conflict DO nothing;

--Cliente

INSERT INTO cliente (nome, data_nascimento, email, usuario_id, telefone)
VALUES ('Alice', '1990-05-15', 'alice@example.com', 1, '123456789')
ON conflict DO nothing;

INSERT INTO cliente (nome, data_nascimento, email, usuario_id, telefone)
VALUES ('Bob', '1985-08-20', 'bob@example.com',2, '987654321')
ON conflict DO nothing;

INSERT INTO cliente (nome, data_nascimento, email, usuario_id, telefone)
VALUES ('Charlie', '1988-03-10', 'charlie@example.com', 3, '111222333')
ON conflict DO nothing;

INSERT INTO cliente (nome, data_nascimento, email, usuario_id, telefone)
VALUES ('Diana', '1992-11-25', 'diana@example.com', 4, '444555666')
ON conflict DO nothing;

INSERT INTO cliente (nome, data_nascimento, email, usuario_id, telefone)
VALUES ('Elena', '1980-12-05', 'elena@example.com', 5, '777888999')
ON conflict DO nothing;

INSERT INTO cliente (nome, data_nascimento, email, usuario_id, telefone)
VALUES ('Frank', '1975-06-30', 'frank@example.com', 6, '000111222')
ON conflict DO nothing;

INSERT INTO cliente (nome, data_nascimento, email, usuario_id, telefone)
VALUES ('Gina', '1982-09-18', 'gina@example.com', 7, '333444555')
ON conflict DO nothing;

INSERT INTO cliente (nome, data_nascimento, email, usuario_id, telefone)
VALUES ('Harry', '1978-04-22', 'harry@example.com', 8, '666777888')
ON conflict DO nothing;

INSERT INTO cliente (nome, data_nascimento, email, usuario_id, telefone)
VALUES ('Irene', '1995-07-14', 'irene@example.com', 9, '999000111')
ON conflict DO nothing;

INSERT INTO cliente (nome, data_nascimento, email, usuario_id, telefone)
VALUES ('Jack', '1987-02-08', 'jack@example.com', 10, '222333444')
ON conflict DO nothing;

--Endereco
INSERT INTO endereco (logradouro, cep, bairro, numero, cliente_id, apelido, complemento)
VALUES
    ('Rua A', '12345-678', 'Centro', '100', 1, 'Casa Principal', 'Apartamento 101')
ON CONFLICT DO NOTHING;

INSERT INTO endereco (logradouro, cep, bairro, numero, cliente_id, apelido, complemento)
VALUES
    ('Avenida B', '54321-876', 'Bela Vista', '200', 2, 'Casa Amarela', 'Bloco A, Sala 1')
ON CONFLICT DO NOTHING;

INSERT INTO endereco (logradouro, cep, bairro, numero, cliente_id, apelido, complemento)
VALUES
    ('Rua C', '98765-432', 'Jardim Botânico', '300', 3, 'Casa Azul', 'Fundos')
ON CONFLICT DO NOTHING;

INSERT INTO endereco (logradouro, cep, bairro, numero, cliente_id, apelido, complemento)
VALUES
    ('Avenida D', '13579-246', 'Alvorada', '400', 4, 'Casa Vermelha', 'Cobertura')
ON CONFLICT DO NOTHING;

INSERT INTO endereco (logradouro, cep, bairro, numero, cliente_id, apelido, complemento)
VALUES
    ('Rua E', '64237-951', 'Campo Grande', '500', 5, 'Casa Verde', 'Andar Térreo')
ON CONFLICT DO NOTHING;

INSERT INTO endereco (logradouro, cep, bairro, numero, cliente_id, apelido, complemento)
VALUES
    ('Avenida F', '86420-159', 'Vila Nova', '600', 6, 'Casa Rosa', 'Apartamento 102')
ON CONFLICT DO NOTHING;

INSERT INTO endereco (logradouro, cep, bairro, numero, cliente_id, apelido, complemento)
VALUES
    ('Rua G', '24680-357', 'São Francisco', '700', 7, 'Casa Laranja', 'Frente')
ON CONFLICT DO NOTHING;

INSERT INTO endereco (logradouro, cep, bairro, numero, cliente_id, apelido, complemento)
VALUES
    ('Avenida H', '97531-468', 'Liberdade', '800', 8, 'Casa Branca', 'Garagem')
ON CONFLICT DO NOTHING;

INSERT INTO endereco (logradouro, cep, bairro, numero, cliente_id, apelido, complemento)
VALUES
    ('Rua I', '35791-624', 'Santo Antônio', '900', 9, 'Casa Preta', 'Sobrado')
ON CONFLICT DO NOTHING;

INSERT INTO endereco (logradouro, cep, bairro, numero, cliente_id, apelido, complemento)
VALUES
    ('Avenida J', '58642-713', 'Jardim Paulista', '1000', 10, 'Casa Marrom', 'Apartamento 103')
ON CONFLICT DO NOTHING;

--Produto

-- Jogos de Cartas
INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Uno', 'uno.png', 19.99, 'CARTAS', 'Um divertido jogo de cartas para toda a família.', 'Livre', '2-10')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Dominion', 'dominion.png', 29.99, 'CARTAS', 'Um jogo de construção de baralhos estratégico.', '10+', '2-4')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Exploding Kittens', 'exploding_kittens.png', 24.99, 'CARTAS', 'Um jogo de cartas rápido e maluco.', '16+', '2-5')
ON CONFLICT DO NOTHING;

-- Jogos de Tabuleiro
INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Catan', 'catan.png', 39.99, 'TABULEIRO', 'Construa estradas, cidades e negocie recursos neste clássico jogo de tabuleiro.', '10+', '3-4')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Ticket to Ride', 'ticket_to_ride.png', 34.99, 'TABULEIRO', 'Viaje de trem pelos Estados Unidos neste empolgante jogo de tabuleiro.', '8+', '2-5')
ON CONFLICT DO NOTHING;

-- Jogos de RPG
INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Dungeons & Dragons: Starter Set', 'dnd_starter_set.png', 29.99, 'RPG', 'Entre em um mundo de aventuras e magia com este conjunto inicial de Dungeons & Dragons.', '12+', '3-6')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Pathfinder Core Rulebook', 'pathfinder_core_rulebook.png', 49.99, 'RPG', 'Um conjunto abrangente de regras para o jogo de RPG Pathfinder.', '14+', '2+')
ON CONFLICT DO NOTHING;

-- Cartas Magic
INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Magic: The Gathering - Core Set 2024', 'magic_core_set_2024.png', 39.99, 'MAGIC', 'O mais recente conjunto básico de cartas para o popular jogo de cartas Magic: The Gathering.', '13+', '2')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Magic: The Gathering - Commander Legends', 'commander_legends.png', 49.99, 'MAGIC', 'Um conjunto de cartas projetado para o formato Commander do Magic: The Gathering.', '13+', '2+')
ON CONFLICT DO NOTHING;

-- Mais jogos de Tabuleiro
INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Azul', 'azul.png', 49.99, 'TABULEIRO', 'Crie padrões de azulejos para decorar o Palácio Real de Évora.', '8+', '2-4')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Scythe', 'scythe.png', 59.99, 'TABULEIRO', 'Lute por recursos e território em uma Europa alternativa dos anos 1920.', '14+', '1-7')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('7 Wonders', '7_wonders.png', 49.99, 'TABULEIRO', 'Construa sua civilização e alcance a glória em apenas 7 eras.', '10+', '3-7')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Terraforming Mars', 'terraforming_mars.png', 59.99, 'TABULEIRO', 'Transforme o Planeta Vermelho em um local habitável para a humanidade.', '12+', '1-5')
ON CONFLICT DO NOTHING;

-- Mais jogos de RPG
INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Starfinder Core Rulebook', 'starfinder_core_rulebook.png', 54.99, 'RPG', 'Explore o espaço sideral e lute contra alienígenas neste jogo de RPG de ficção científica.', '14+', '2-6')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Call of Cthulhu Investigator Handbook', 'cthulhu_investigator_handbook.png', 39.99, 'RPG', 'Detalhes e dicas para criar e interpretar investigadores em Call of Cthulhu.', '16+', '1+')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Vampire: The Masquerade 5th Edition', 'vampire_5th_edition.png', 44.99, 'RPG', 'Assuma o papel de um vampiro e navegue pelas intrigas da sociedade vampírica.', '18+', '2-5')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Call of Cthulhu Keeper Rulebook', 'cthulhu_keeper_rulebook.png', 39.99, 'RPG', 'Guia essencial para o mestre de Call of Cthulhu, repleto de horrores cósmicos.', '16+', '1+')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Dungeon World', 'dungeon_world.png', 29.99, 'RPG', 'Explore masmorras, enfrente monstros e crie histórias épicas neste RPG narrativo.', '12+', '2-6')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Fiasco', 'fiasco.png', 39.99, 'RPG', 'Crie suas próprias histórias de desastres e tragédias neste RPG de improvisação.', '16+', '3-5')
ON CONFLICT DO NOTHING;

-- Mais Cartas Magic
INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Magic: The Gathering - Adventures in the Forgotten Realms', 'adventures_in_the_forgotten_realms.png', 44.99, 'MAGIC', 'Aventure-se no mundo de Dungeons & Dragons com este conjunto de cartas.', '13+', '2')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Magic: The Gathering - Strixhaven: School of Mages', 'strixhaven_school_of_mages.png', 39.99, 'MAGIC', 'Junte-se a uma das cinco faculdades mágicas de Strixhaven e mostre seu conhecimento.', '13+', '2')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Magic: The Gathering - Zendikar Rising', 'zendikar_rising.png', 49.99, 'MAGIC', 'Explore o mundo selvagem de Zendikar em busca de tesouros e aventuras.', '13+', '2')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Magic: The Gathering - Kaldheim', 'kaldheim.png', 44.99, 'MAGIC', 'Viaje para o mundo viking de Kaldheim e desafie os deuses para ganhar poder.', '13+', '2')
ON CONFLICT DO NOTHING;

-- Mais jogos de Cartas
INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Uno Flip', 'uno_flip.png', 14.99, 'CARTAS', 'Um emocionante jogo de cartas onde as regras podem ser revertidas a qualquer momento.', '7+', '2-10')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Legendary: A Marvel Deck Building Game', 'legendary_marvel.png', 54.99, 'CARTAS', 'Monte sua equipe de super-heróis e derrote os vilões neste emocionante jogo de construção de deck.', '12+', '1-5')
ON CONFLICT DO NOTHING;

--Estoque
INSERT INTO estoque (quantidade, produto_id)
VALUES (15, 1)
ON CONFLICT DO NOTHING;

INSERT INTO estoque (quantidade, produto_id)
VALUES (20, 2)
ON CONFLICT DO NOTHING;

INSERT INTO estoque (quantidade, produto_id)
VALUES (30, 3)
ON CONFLICT DO NOTHING;

INSERT INTO estoque (quantidade, produto_id)
VALUES (25, 6)
ON CONFLICT DO NOTHING;

INSERT INTO estoque (quantidade, produto_id)
VALUES (40, 4)
ON CONFLICT DO NOTHING;

INSERT INTO estoque (quantidade, produto_id)
VALUES (35, 9)
ON CONFLICT DO NOTHING;

INSERT INTO estoque (quantidade, produto_id)
VALUES (45, 8)
ON CONFLICT DO NOTHING;

INSERT INTO estoque (quantidade, produto_id)
VALUES (55, 5)
ON CONFLICT DO NOTHING;

INSERT INTO estoque (quantidade, produto_id)
VALUES (60, 7)
ON CONFLICT DO NOTHING;

-- Pedido
INSERT INTO pedido (valor_total, forma_pagamento, status, endereco_id, cliente_id)
VALUES (274.91, 'PIX','PENDENTE', 1, 1)
ON CONFLICT DO NOTHING;

INSERT INTO pedido (valor_total, forma_pagamento, status, endereco_id, cliente_id)
VALUES (309.93, 'CARTAO','PAGO', 2, 2)
ON CONFLICT DO NOTHING;

INSERT INTO pedido (valor_total, forma_pagamento, status, endereco_id, cliente_id)
VALUES (819.82, 'BOLETO','ENTREGUE', 3, 3)
ON CONFLICT DO NOTHING;

INSERT INTO pedido (valor_total, forma_pagamento, status, endereco_id, cliente_id)
VALUES (299.85, 'PIX','ENTREGUE', 4, 4)
ON CONFLICT DO NOTHING;

INSERT INTO pedido (valor_total, forma_pagamento, status, endereco_id, cliente_id)
VALUES (614.85, 'CARTAO','CANCELADO', 5, 5)
ON CONFLICT DO NOTHING;

INSERT INTO pedido (valor_total, forma_pagamento, status, endereco_id, cliente_id)
VALUES (89.98, 'BOLETO','CANCELADO', 6, 6)
ON CONFLICT DO NOTHING;


-- PedidoItem
--1
INSERT INTO pedido_item (valor_unitario, quantidade, produto_id, pedido_id)
VALUES (29.99, 5, 2, 1)
ON CONFLICT DO NOTHING;

INSERT INTO pedido_item (valor_unitario, quantidade, produto_id, pedido_id)
VALUES (24.99, 3, 3, 1)
ON CONFLICT DO NOTHING;

INSERT INTO pedido_item (valor_unitario, quantidade, produto_id, pedido_id)
VALUES (39.99, 2, 4, 1)
ON CONFLICT DO NOTHING;

--2
INSERT INTO pedido_item (valor_unitario, quantidade, produto_id, pedido_id)
VALUES (24.99, 1, 3, 2)
ON CONFLICT DO NOTHING;

INSERT INTO pedido_item (valor_unitario, quantidade, produto_id, pedido_id)
VALUES (34.99, 1, 5, 2)
ON CONFLICT DO NOTHING;

INSERT INTO pedido_item (valor_unitario, quantidade, produto_id, pedido_id)
VALUES (49.99, 5, 9, 2)
ON CONFLICT DO NOTHING;

--3
INSERT INTO pedido_item (valor_unitario, quantidade, produto_id, pedido_id)
VALUES (39.99, 8, 8, 3)
ON CONFLICT DO NOTHING;

INSERT INTO pedido_item (valor_unitario, quantidade, produto_id, pedido_id)
VALUES (49.99, 10, 7, 3)
ON CONFLICT DO NOTHING;

--4
INSERT INTO pedido_item (valor_unitario, quantidade, produto_id, pedido_id)
VALUES (19.99, 15, 1, 4)
ON CONFLICT DO NOTHING;

--5
INSERT INTO pedido_item (valor_unitario, quantidade, produto_id, pedido_id)
VALUES (29.99, 3, 2, 5)
ON CONFLICT DO NOTHING;

INSERT INTO pedido_item (valor_unitario, quantidade, produto_id, pedido_id)
VALUES (24.99, 3, 3, 5)
ON CONFLICT DO NOTHING;

INSERT INTO pedido_item (valor_unitario, quantidade, produto_id, pedido_id)
VALUES (49.99, 9, 7, 5)
ON CONFLICT DO NOTHING;

--6
INSERT INTO pedido_item (valor_unitario, quantidade, produto_id, pedido_id)
VALUES (39.99, 1, 4, 6)
ON CONFLICT DO NOTHING;

INSERT INTO pedido_item (valor_unitario, quantidade, produto_id, pedido_id)
VALUES (49.99, 1, 8, 6)
ON CONFLICT DO NOTHING;

--Pix
INSERT INTO pix (valor, data_expiracao, pedido_id)
VALUES (274.91, TIMESTAMP '2024-06-09 21:55:59.2836906', 1)
ON CONFLICT DO NOTHING;

INSERT INTO pix (valor, data_expiracao, pedido_id)
VALUES (299.85, TIMESTAMP '2024-06-10 18:30:00.0000000', 4)
ON CONFLICT DO NOTHING;

--Cartao
INSERT INTO cartao (numero_cartao, nome_titular, codigo_seguranca, valor, pedido_id)
VALUES ('9876543210987654', 'Maria Oliveira', '456', 309.93, 2)
ON CONFLICT DO NOTHING;

INSERT INTO cartao (numero_cartao, nome_titular, codigo_seguranca, valor, pedido_id)
VALUES ('1234567890123456', 'João da Silva', '123', 614.85, 5)
ON CONFLICT DO NOTHING;

--Boleto
INSERT INTO boleto (valor, data_vencimento, pedido_id)
VALUES (819.82, '2024-07-15', 3)
ON CONFLICT DO NOTHING;

INSERT INTO boleto (valor, data_vencimento, pedido_id)
VALUES (89.98, '2024-08-20', 6)
ON CONFLICT DO NOTHING;





