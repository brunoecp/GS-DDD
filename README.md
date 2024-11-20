# Projeto feito para a entrega da materia da GS-DDD 
**Todos os endpoints estarão abaixo, junto de seus exemplos**
- [Cliente](#cliente)
- [Instalação](#instalação)
- [Contrato](#contrato)

## Cliente

`GET` /cliente

Saida:
````js
[
	{
		"id": "82dc8518-3faa-4b07-9024-bd392f6bc7bb",
		"nome": "Brunin ",
		"endereco": "Rua das Flores, 41",
		"documento": "966.351.800-60",
		"tipo": "PF",
		"cep": "055345-120",
		"ativo": true
	},
	{
		"id": "2426c1b1-46c4-4716-a7a2-4786dd3ad68c",
		"nome": "joão da silva",
		"endereco": "Rua das Flores, 41",
		"documento": "966.351.800-60",
		"tipo": "PF",
		"cep": "055345-120",
		"ativo": false
	}
]
````
----
`GET` /cliente/id

Saida: 
````js
{
	"id": "82dc8518-3faa-4b07-9024-bd392f6bc7bb",
	"nome": "Brunin ",
	"endereco": "Rua das Flores, 41",
	"documento": "966.351.800-60",
	"tipo": "PF",
	"cep": "055345-120",
	"ativo": true
}
````
`POST` /cliente

Entrada:
````js
{
    "nome": "Brunin ",
    "endereco": "Rua das Flores, 41",
    "documento": "966.351.800-60",
    "tipo": "PF",
    "cep": "055345-120"
}
````
Saida:
````js
{
	"id": "91539440-1915-4707-8afa-d253e9f0111e",
	"nome": "Brunin ",
	"endereco": "Rua das Flores, 41",
	"documento": "966.351.800-60",
	"tipo": "PF",
	"cep": "055345-120",
	"ativo": true
}
````

`DELETE` /cliente/id

Saida: 
````js
{
	"id": "82dc8518-3faa-4b07-9024-bd392f6bc7bb",
	"nome": "Brunin ",
	"endereco": "Rua das Flores, 41",
	"documento": "966.351.800-60",
	"tipo": "PF",
	"cep": "055345-120",
	"ativo": false
}
````
## Instalação

`GET` /instalacao

Saida:
````js
[
	{
		"id": "236fe828-ab6b-4123-89b3-e3c599d94ec9",
		"endereco": "Rua rosario, 191",
		"cep": "02925-160",
		"ativo": true
	},
	{
		"id": "b03b6dac-8953-434f-b489-a7e14476b7c6",
		"endereco": "Rua antonieta Leitao, 171",
		"cep": "02925-160",
		"ativo": true
	}
]
````
----
`GET` /instalacao/id

Saida: 
````js
{
{
	"id": "3ef164cf-9a54-4d43-acbb-4237d6cf0726",
	"endereco": "Rua das Flores, 41",
	"cep": "055345-120"
    "ativo": true
}
}
````
`POST` /instalacao

Entrada:
````js
{
    "endereco": "Rua antonieta Leitao, 171",
    "cep": "02925-160"
}
````
Saida:
````js
{
	"id": "54508908-22d3-43b3-9e67-69f451b16ebf",
	"endereco": "Rua antonieta Leitao, 171",
	"cep": "02925-160",
	"ativo": true
}
````

`DELETE` /instalacao/id

Saida: 
````js
{
	"id": "236fe828-ab6b-4123-89b3-e3c599d94ec9",
	"endereco": "Rua rosario, 191",
	"cep": "02925-160",
	"ativo": false
}
````
## contrato

`GET` /contrato

Saida:
````js
[
	{
		"cliente": {
			"id": "82dc8518-3faa-4b07-9024-bd392f6bc7bb",
			"nome": "Brunin ",
			"endereco": "Rua das Flores, 41",
			"documento": "966.351.800-60",
			"tipo": "PF",
			"cep": "055345-120",
			"ativo": false
		},
		"instalacao": {
			"id": "236fe828-ab6b-4123-89b3-e3c599d94ec9",
			"endereco": "Rua rosario, 191",
			"cep": "02925-160",
			"ativo": false
		},
		"dtInicio": "2024-11-20T23:28:26.694+00:00",
		"timeframe": 180,
		"ativo": true,
		"id": "a9b7ca29-ab21-4518-8366-48fc403127c7"
	}
]
````
----
`GET` /contrato/id

Saida: 
````js
{
	"cliente": {
		"id": "82dc8518-3faa-4b07-9024-bd392f6bc7bb",
		"nome": "Brunin ",
		"endereco": "Rua das Flores, 41",
		"documento": "966.351.800-60",
		"tipo": "PF",
		"cep": "055345-120",
		"ativo": false
	},
	"instalacao": {
		"id": "236fe828-ab6b-4123-89b3-e3c599d94ec9",
		"endereco": "Rua rosario, 191",
		"cep": "02925-160",
		"ativo": false
	},
	"dtInicio": "2024-11-20T23:28:26.694+00:00",
	"timeframe": 180,
	"ativo": true,
	"id": "a9b7ca29-ab21-4518-8366-48fc403127c7"
}
````
`POST` /contrato

Entrada:
````js
{
    "cliente":{"id": "82dc8518-3faa-4b07-9024-bd392f6bc7bb"},
    "instalacao": {"id":"236fe828-ab6b-4123-89b3-e3c599d94ec9"},
    "timeframe": 180
}
````
Saida:
````js
{
	"cliente": {
		"id": "82dc8518-3faa-4b07-9024-bd392f6bc7bb",
		"nome": null,
		"endereco": null,
		"documento": null,
		"tipo": null,
		"cep": null,
		"ativo": false
	},
	"instalacao": {
		"id": "236fe828-ab6b-4123-89b3-e3c599d94ec9",
		"endereco": null,
		"cep": null,
		"ativo": false
	},
	"dtInicio": "2024-11-20T23:28:26.694+00:00",
	"timeframe": 180,
	"ativo": true,
	"id": "c5786075-e0be-4419-a647-57fb181e3d99"
}
````

`DELETE` /contrato/id

Saida: 
````js
{
	"cliente": {
		"id": "82dc8518-3faa-4b07-9024-bd392f6bc7bb",
		"nome": "Brunin ",
		"endereco": "Rua das Flores, 41",
		"documento": "966.351.800-60",
		"tipo": "PF",
		"cep": "055345-120",
		"ativo": false
	},
	"instalacao": {
		"id": "236fe828-ab6b-4123-89b3-e3c599d94ec9",
		"endereco": "Rua rosario, 191",
		"cep": "02925-160",
		"ativo": false
	},
	"dtInicio": "2024-11-20T23:28:26.694+00:00",
	"timeframe": 180,
	"ativo": false,
	"id": "a9b7ca29-ab21-4518-8366-48fc403127c7"
}
````
## Registro Consumo

`GET` /registroconsumo

Saida:
````js
[
	{
		"id": "9afd6d5d-611f-4d86-9574-6c51362fc88c",
		"idContrato": {
			"cliente": {
				"id": "82dc8518-3faa-4b07-9024-bd392f6bc7bb",
				"nome": "Brunin ",
				"endereco": "Rua das Flores, 41",
				"documento": "966.351.800-60",
				"tipo": "PF",
				"cep": "055345-120",
				"ativo": false
			},
			"instalacao": {
				"id": "236fe828-ab6b-4123-89b3-e3c599d94ec9",
				"endereco": "Rua rosario, 191",
				"cep": "02925-160",
				"ativo": false
			},
			"dtInicio": "2024-11-20T23:28:26.694+00:00",
			"timeframe": 180,
			"ativo": false,
			"id": "a9b7ca29-ab21-4518-8366-48fc403127c7"
		},
		"consumo": 415.9,
		"medicao": "2024-11-20T23:34:26.426+00:00",
		"created": "2024-11-20T23:33:50.962+00:00"
	}
]
````
----
`GET` /registroconsumo/id

Saida: 
````js
{
	"id": "9afd6d5d-611f-4d86-9574-6c51362fc88c",
	"idContrato": {
		"cliente": {
			"id": "82dc8518-3faa-4b07-9024-bd392f6bc7bb",
			"nome": "Brunin ",
			"endereco": "Rua das Flores, 41",
			"documento": "966.351.800-60",
			"tipo": "PF",
			"cep": "055345-120",
			"ativo": false
		},
		"instalacao": {
			"id": "236fe828-ab6b-4123-89b3-e3c599d94ec9",
			"endereco": "Rua rosario, 191",
			"cep": "02925-160",
			"ativo": false
		},
		"dtInicio": "2024-11-20T23:28:26.694+00:00",
		"timeframe": 180,
		"ativo": false,
		"id": "a9b7ca29-ab21-4518-8366-48fc403127c7"
	},
	"consumo": 420.9,
	"medicao": "2024-11-20T23:34:48.406+00:00",
	"created": "2024-11-20T23:33:50.962+00:00"
}
````
`POST` /registroconsumo

Entrada:
````js
{
    "idContrato": {"id":"a9b7ca29-ab21-4518-8366-48fc403127c7"},
    "consumo": 410.90,
    "medicao": "2024-11-20"
}
````
Saida:
````js
{
	"id": "c9688af8-aca0-46f2-bdc0-f6cabbf17f27",
	"idContrato": {
		"cliente": null,
		"instalacao": null,
		"dtInicio": null,
		"timeframe": 0,
		"ativo": false,
		"id": "a9b7ca29-ab21-4518-8366-48fc403127c7"
	},
	"consumo": 410.9,
	"medicao": "2024-11-20T00:00:00.000+00:00",
	"created": "2024-11-20T23:33:50.962+00:00"
}
````

## Registro Producao

`GET` /registroproducao

Saida:
````js
[
	{
		"id": "9f38c42d-f26d-428b-b72e-942acb972891",
		"idContrato": {
			"cliente": {
				"id": "82dc8518-3faa-4b07-9024-bd392f6bc7bb",
				"nome": "Brunin ",
				"endereco": "Rua das Flores, 41",
				"documento": "966.351.800-60",
				"tipo": "PF",
				"cep": "055345-120",
				"ativo": false
			},
			"instalacao": {
				"id": "236fe828-ab6b-4123-89b3-e3c599d94ec9",
				"endereco": "Rua rosario, 191",
				"cep": "02925-160",
				"ativo": false
			},
			"dtInicio": "2024-11-20T23:28:26.694+00:00",
			"timeframe": 180,
			"ativo": false,
			"id": "a9b7ca29-ab21-4518-8366-48fc403127c7"
		},
		"producao": 415.9,
		"medicao": "2024-11-20T23:36:53.286+00:00",
		"created": "2024-11-20T23:36:19.615+00:00"
	}
]
````
----
`GET` /registroproducao/id

Saida: 
````js
{
	"id": "9f38c42d-f26d-428b-b72e-942acb972891",
	"idContrato": {
		"cliente": {
			"id": "82dc8518-3faa-4b07-9024-bd392f6bc7bb",
			"nome": "Brunin ",
			"endereco": "Rua das Flores, 41",
			"documento": "966.351.800-60",
			"tipo": "PF",
			"cep": "055345-120",
			"ativo": false
		},
		"instalacao": {
			"id": "236fe828-ab6b-4123-89b3-e3c599d94ec9",
			"endereco": "Rua rosario, 191",
			"cep": "02925-160",
			"ativo": false
		},
		"dtInicio": "2024-11-20T23:28:26.694+00:00",
		"timeframe": 180,
		"ativo": false,
		"id": "a9b7ca29-ab21-4518-8366-48fc403127c7"
	},
	"producao": 420.9,
	"medicao": "2024-11-20T23:37:13.112+00:00",
	"created": "2024-11-20T23:36:19.615+00:00"
}
````
`POST` /registroproducao

Entrada:
````js
{
    "idContrato": {"id":"a9b7ca29-ab21-4518-8366-48fc403127c7"},
    "producao": 410.90,
    "medicao": "2024-11-20"
}
````
Saida:
````js
{
	"id": "c5b7fc85-0937-488d-8184-960be1e261e1",
	"idContrato": {
		"cliente": null,
		"instalacao": null,
		"dtInicio": null,
		"timeframe": 0,
		"ativo": false,
		"id": "a9b7ca29-ab21-4518-8366-48fc403127c7"
	},
	"producao": 410.9,
	"medicao": "2024-11-20T00:00:00.000+00:00",
	"created": "2024-11-20T23:36:19.615+00:00"
}
````