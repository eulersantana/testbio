### Backend Test

1. Importar os dados de UBSs disponíveis em formato CSV no site: http://dados.gov.br/dataset/unidadesbasicas-de-saude-ubs
2. Desenvolver uma aplicação Web API, bem simples, com apenas uma rota de consulta para essas
informações, que deve trazer a lista de UBSs mais próximas da localização fornececida, conforme exemplo
abaixo:

### Tarefas



```json

{
	current_page: 1,
	per_page: 1,
	total_entries: 37690,
	entries: [{
		id: 39860,
		name: "UBS REAL PQ PAULO MANGABEIRA ALBERNAZ FILHO",
		address: "RUA BARAO MELGACO",
		city: "São Paulo",
		phone: "1137582329",
		geocode: {
			lat: -23.6099946498864,
			long: -46.7057347297655
		},
		scores: {
			size: 3,
			adaptation_for_seniors: 3,
			medical_equipment: 1,
			medicine: 3
		}
	}]
}
```

Crie endpoints para as seguintes ações:

GET: /find_ubs?query=-23.604936,-46.692999&page=1&per_page=1

### Requisitos


- [] Temos preferência por Java, porém, utilize a linguagem e frameworks de sua preferência
- [] Utilize as boas práticas de desenvolvimento de software que achar necessário
- [] Organize seu projeto com gerenciador de pacote, testes e documentação
- [] Deve ser possível utilizar o retorno da API em aplicações Web e Mobile
- [] Deve conter a pasta .git no projeto entregue
- [] Execução do projeto com Docker
- [] Ter aplicação deployada e rodando em algum server (ex.: heroku)
- [] Caso deseje desenvolver a aplicação web, use um framework JS de sua preferência e, se quiser, um pré-processador CSS

### Critérios de avaliação

1. Organização do código
2. Qualidade do código
3. Testes
4. Documentação do projeto
5. Quantidade de requisitos preenchidos
6. Requisitos bônus


### Link Heroku
https://bioteste.herokuapp.com/swagger-ui.html
