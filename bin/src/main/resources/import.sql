insert into cozinhas (nome) values('Tailandesa')
insert into cozinhas (nome) values('Chinesa')
insert into cozinhas (nome) values('Portuguesa')
insert into cozinhas (nome) values('Italiana')

insert into restaurantes (nome, tx_frete, cozinha_id) values('Camomila', 3.49, 4)
insert into restaurantes (nome, tx_frete, cozinha_id) values('Vanilla', 1.49, 3)

insert into estado (nome) values('Bahia')
insert into estado (nome) values('São Paulo')
insert into estado (nome) values('Sergipe')
insert into estado (nome) values('Rio de Janeiro')
insert into estado (nome) values('Espirito Santo')

insert into forma_pagamento (descricao) values('Cartão de Credito')
insert into forma_pagamento (descricao) values('Cartão de Debito')
insert into forma_pagamento (descricao) values('Dinheiro')
insert into forma_pagamento (descricao) values('Pix')
insert into forma_pagamento (descricao) values('PicPay')
insert into forma_pagamento (descricao) values('Transferência')

insert into permissao (nome, descricao) values('Autorizado', 'Pode Entrar')
insert into permissao (nome, descricao) values('Barrado', 'Não pode entrar')
insert into permissao (nome, descricao) values('Senha Desatualizada', 'Ligue para TI')

insert into cidade(nome, estado_id) values('Lauro de Freitas', 1)
insert into cidade(nome, estado_id) values('Ubatuba', 2)
insert into cidade(nome, estado_id) values('Itabaiana', 3)
insert into cidade(nome, estado_id) values('Rio das Ostras', 4)
insert into cidade(nome, estado_id) values('espirito Santo', 5)

