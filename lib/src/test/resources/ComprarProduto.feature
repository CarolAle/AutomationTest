#Projeto usa Cucumber + Selenium + Page Objects
#language: pt

Funcionalidade: Realizar compra

Contexto: Acessar o site
	Dado que acesso o site "http://automationpractice.com/index.php"
	E entro na categoria vestido casual
	
	Cenario: Realizar compra de vestido casual
	Quando clico no produto "Printed Dress"
	E clico no botão "ADD to cart"
	E clico em "Proceed to checkout"
	E clico em "Proceed to checkout" na tela de resumo
	E Preencho os campos email e senha com "testemystore1@mailinator.com" e "12345" com uma conta válida
	E clico em "Proceed to checkout" no passo 3
	E Clico em aceitar os termos e "Proceed to checkout" no passo 4
	E Clico na opção Pay by bank wire"
	E Clico na opção "I confirm my order"