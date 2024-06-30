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
VALUES ('Matryoshka', 'Matryoshka-caixa.png', 59.90, 'CARTAS', 'Algumas Matryoshkas raras estão sendo trocadas por colecionadores de antiguidades. Todos tentam colecionar um conjunto completo ou pelo menos bonecas do mesmo tamanho. Quem terá a coleção mais valiosa ao fim da disputa?.', 'Livre', '3-5')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('QU4TO', 'Qu4to-caixa.png', 59.90, 'CARTAS', 'QU4TO é um jogo de cartas dinâmico e divertido, onde jogadores tentam descartar o mais rapidamente suas mãos, jogando conjuntos de cartas de números iguais ou sequências.', '10+', '2-5')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Nem a Pato', 'Caixa-Nem-a-Pato.png', 59.90, 'CARTAS', 'Adivinhe o número, mas cuidado para não passar do ponto!', '16+', '2-10')
ON CONFLICT DO NOTHING;

-- Jogos de Tabuleiro
INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('A.E.R.O.', 'Caixav4-Aero.png', 134.90, 'TABULEIRO', 'A gangue do Meleca está a solta, aterrorizando os planetas de nossa galáxia! Apenas um grupo qualificado poderia dar um basta nesse grupo de malfeitores, o A.E.R.O. (Agentes Espaciais de Resgate Orbital).', '10+', '2-4')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Àiyé', 'Aiye-caixa1.png', 149.90, 'TABULEIRO', 'Em Àiyé os jogadores administram o destino de um povo ancestral, determinando aqueles que tomam a liderança e trabalham em conjunto no dia-a-dia para o bem de todos. Com a manipulação das energias na mancala, ela se modifica para que os jogadores criem combinações poderosas, se enfrentem e acumulem pontos em busca da vitória.', '8+', '2-4')
ON CONFLICT DO NOTHING;

-- Jogos de RPG
INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Dungeons & Dragons: Starter Set', 'dungeon-dragons-set.png', 29.99, 'RPG', 'Entre em um mundo de aventuras e magia com este conjunto inicial de Dungeons & Dragons.', '12+', '3-6')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Pathfinder Core Rulebook', 'pathfinder.png', 49.99, 'RPG', 'Um conjunto abrangente de regras para o jogo de RPG Pathfinder.', '14+', '2+')
ON CONFLICT DO NOTHING;

-- Cartas Magic
INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Magic: The Gathering - Core Set 2024', 'Magic-The-Gathering-Core-Set-2024.png', 39.99, 'MAGIC', 'O mais recente conjunto básico de cartas para o popular jogo de cartas Magic: The Gathering.', '13+', '2')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Magic: The Gathering - Commander Legends', 'Magic-The-Gathering-Commander-Legends.png', 49.99, 'MAGIC', 'Um conjunto de cartas projetado para o formato Commander do Magic: The Gathering.', '13+', '2+')
ON CONFLICT DO NOTHING;

-- Mais jogos de Tabuleiro
INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Amígdala', 'amygala-caixa.png', 249.90, 'TABULEIRO', 'A vida é cheia de emoções, e a região do cérebro associada principalmente ao processamento dessas emoções é a amígdala.', '8+', '2-4')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Anachrony', 'caixa-Anachrony-1.png', 449.90, 'TABULEIRO', 'Anachrony apresenta um sistema único de colocação de trabalhadores de duas camadas. Para viajar à Capital ou aventurar-se nas áreas devastadas de recursos, os jogadores precisam não de apenas vários especialistas (engenheiros, cientistas, administradores e gênios), mas também de Exoesqueletos para protegê-los e melhorá-los – e ambos são escassos.', '14+', '1-4')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Anachrony', 'caixa-Anachrony-Expansao-Classica-1.png', 299.90, 'TABULEIRO', 'Leve sua experiência de Anachrony para um novo nível com três novos módulos.', '10+', '1-4')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Cartógrafos', 'cartografos.png', 99.90, 'TABULEIRO', 'Em Cartógrafos, os jogadores competem para ganhar a maior quantidade de estrelas de reputação ao longo de quatro estações do ano. A cada estação, os jogadores desenham em suas folhas de mapa e ganham reputação cumprindo os decretos da rainha antes do término da estação. O jogador com mais estrelas de reputação ao fim do inverno é o vencedor!.', '12+', '1-100')
ON CONFLICT DO NOTHING;

-- Mais jogos de RPG
INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Starfinder Core Rulebook', 'Starfinder-Core-Rulebook.png', 54.99, 'RPG', 'Explore o espaço sideral e lute contra alienígenas neste jogo de RPG de ficção científica.', '14+', '2-6')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Call of Cthulhu Investigator Handbook', 'InvestigatorHandbook.png', 39.99, 'RPG', 'Detalhes e dicas para criar e interpretar investigadores em Call of Cthulhu.', '16+', '1+')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Vampire: The Masquerade 5th Edition', 'Vampire-The-Masquerade-5th-Edition.png', 44.99, 'RPG', 'Assuma o papel de um vampiro e navegue pelas intrigas da sociedade vampírica.', '18+', '2-5')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Call of Cthulhu Keeper Rulebook', 'Call-of-Cthulhu-Keeper-Rulebook.png', 39.99, 'RPG', 'Guia essencial para o mestre de Call of Cthulhu, repleto de horrores cósmicos.', '16+', '1+')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Dungeon World', '20_DungeonWorld.png', 29.99, 'RPG', 'Explore masmorras, enfrente monstros e crie histórias épicas neste RPG narrativo.', '12+', '2-6')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Fiasco', 'fiasco.png', 39.99, 'RPG', 'Crie suas próprias histórias de desastres e tragédias neste RPG de improvisação.', '16+', '3-5')
ON CONFLICT DO NOTHING;

-- Mais Cartas Magic
INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Magic: The Gathering - Adventures in the Forgotten Realms', 'Magic-The-Gathering-Adventures-in-the-Forgotten-Realms.png', 44.99, 'MAGIC', 'Aventure-se no mundo de Dungeons & Dragons com este conjunto de cartas.', '13+', '2')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Magic: The Gathering - Strixhaven: School of Mages', 'Magic-The-Gathering-Strixhaven-School-of-Mages.png', 39.99, 'MAGIC', 'Junte-se a uma das cinco faculdades mágicas de Strixhaven e mostre seu conhecimento.', '13+', '2')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Magic: The Gathering - Zendikar Rising', 'Magic-The-Gathering-Zendikar-Rising.png', 49.99, 'MAGIC', 'Explore o mundo selvagem de Zendikar em busca de tesouros e aventuras.', '13+', '2')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Magic: The Gathering - Kaldheim', 'Magic-The-Gathering-Kaldheim.png', 44.99, 'MAGIC', 'Viaje para o mundo viking de Kaldheim e desafie os deuses para ganhar poder.', '13+', '2')
ON CONFLICT DO NOTHING;

-- Mais jogos de Cartas
INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Uno Flip', 'Uno-Flip.png', 14.99, 'CARTAS', 'Um emocionante jogo de cartas onde as regras podem ser revertidas a qualquer momento.', '7+', '2-10')
ON CONFLICT DO NOTHING;

INSERT INTO produto (nome, imagem, valor_unitario, categoria, descricao, classificacao_indicativa, numero_jogadores)
VALUES ('Legendary: A Marvel Deck Building Game', 'legendary.png', 54.99, 'CARTAS', 'Monte sua equipe de super-heróis e derrote os vilões neste emocionante jogo de construção de deck.', '12+', '1-5')
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





