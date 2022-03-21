INSERT INTO tb_departamento(titulo) VALUES('Financeiro');
INSERT INTO tb_departamento(titulo) VALUES('Comercial');
INSERT INTO tb_departamento(titulo) VALUES('Desenvolvimento');


INSERT INTO tb_pessoa(nome, departamento_id) VALUES ('Camila', 1);
INSERT INTO tb_pessoa(nome, departamento_id) VALUES ('Pedro', 2);
INSERT INTO tb_pessoa(nome, departamento_id) VALUES ('Fabiano', 3);
INSERT INTO tb_pessoa(nome, departamento_id) VALUES ('Raquel', 3);
INSERT INTO tb_pessoa(nome, departamento_id) VALUES ('Patricia', 3);
INSERT INTO tb_pessoa(nome, departamento_id) VALUES ('Joaquim', 1);
INSERT INTO tb_pessoa(nome, departamento_id) VALUES ('Eduardo', 3);

INSERT INTO tb_tarefa(titulo, descricao, prazo, departamento_id, duracao, pessoa_id, situacao) VALUES ('Validar NF Janeiro', 'Validar notas recebidas no mês de janeiro', TIMESTAMP WITH TIME ZONE '2022-02-15T01:00:00Z', 1, 14, 1, 1);
INSERT INTO tb_tarefa(titulo, descricao, prazo, departamento_id, duracao, pessoa_id, situacao) VALUES ('Bug 352', 'Corrigir bug 352 na versão 1.25', TIMESTAMP WITH TIME ZONE '2022-05-10T13:00:00Z', 3, 25, null, 0);
INSERT INTO tb_tarefa(titulo, descricao, prazo, departamento_id, duracao, pessoa_id, situacao) VALUES ('Liberação da versão 1.24', 'Disponibilizar pacote para testes', TIMESTAMP WITH TIME ZONE '2022-02-02T:00:45:10Z',3, 2, 1, 0);
INSERT INTO tb_tarefa(titulo, descricao, prazo, departamento_id, duracao, pessoa_id, situacao) VALUES ('Reunião A', 'Reunião com cliente A para apresentação do produto', TIMESTAMP WITH TIME ZONE '2022-02-05T10:20:00Z', 2, 5, null, 0);
INSERT INTO tb_tarefa(titulo, descricao, prazo, departamento_id, duracao, pessoa_id, situacao) VALUES ('Reunião final', 'Fechamento contrato', TIMESTAMP WITH TIME ZONE '2022-03-28T10:30:00Z', 2, 6, null, 0);
INSERT INTO tb_tarefa(titulo, descricao, prazo, departamento_id, duracao, pessoa_id, situacao) VALUES ('Pagamento 01/2022', 'Realizar pagamento dos fornecedores', TIMESTAMP WITH TIME ZONE '2022-01-31T:12:00:00Z', 1, 6, 1, 1);
INSERT INTO tb_tarefa(titulo, descricao, prazo, departamento_id, duracao, pessoa_id, situacao) VALUES ('Bug 401', 'Corrigir bug 401 na versão 1.20', TIMESTAMP WITH TIME ZONE '2022-02-01T08:45:00Z', 3, 2, 4, 1);
INSERT INTO tb_tarefa(titulo, descricao, prazo, departamento_id, duracao, pessoa_id, situacao) VALUES ('Bug 399', 'Corrigir bug 399 na versão 1.20', TIMESTAMP WITH TIME ZONE '2022-01-28T:16:00:00Z', 3, 6, 5, 1);
INSERT INTO tb_tarefa(titulo, descricao, prazo, departamento_id, duracao, pessoa_id, situacao) VALUES ('Reunião B', 'Reunião com cliente B para apresentação do produto', TIMESTAMP WITH TIME ZONE '2022-01-31T13:00:00Z', 2, 5, 2, 1);
INSERT INTO tb_tarefa(titulo, descricao, prazo, departamento_id, duracao, pessoa_id, situacao) VALUES ('Validar NF Fevereiro', 'Validar notas recebidas no mês de fevereiro', TIMESTAMP WITH TIME ZONE '2022-03-15T09:20:00Z', 1, 14, 6, 0);