#Projeto usa Cucumber + Selenium + Page Objects
#language: pt

Funcionalidade: Comprar Produto
	#Fluxo de compras no site Petz
	
	Cenario: Compra a partir de uma Busca
	Dado que o usuário acessa o site Petz
	Quando busca por "coleira" e pressiona Enter
	Então exibe uma lista de produtos relacionados a "coleira"
	Quando escolhe "Coleira Petz Azul para Cães"
	Então exibe o preço de "R$ 49,99"