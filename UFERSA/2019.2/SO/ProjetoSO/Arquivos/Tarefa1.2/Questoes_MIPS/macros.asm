#a) done: para finalizar programa
.macro done
	li $v0, 10
	syscall
.end_macro

#b) print_int: para imprimir inteiro
.macro print_int(%x)
	add $a0, $zero, %x
	li $v0, 1
	syscall
.end_macro

#c) print_char: para imprimir caracter
.macro print_char(%str)
	add $a0, $zero, %str
	li $v0, 11
	syscall
.end_macro

#d) print_string: para imprimir string
.macro print_string(%str)
	.data
		saidaImprimir: .asciiz %str
	
	.text
		la $a0, saidaImprimir
		li $v0, 4
		syscall
.end_macro

#e) read_int: para leitura de inteiro
.macro read_int
	li $v0, 5
	syscall
.end_macro

#f) read_char: para leitura de inteiro
.macro read_char
	li $v0, 12
	syscall
.end_macro

#g) read_string: para leitura de inteiro
.macro read_string
	.data
		entradaUsuario: .space 20
	
	.text
		la $a0, entradaUsuario
		li $a1, 20
		
		li $v0, 8
		syscall
.end_macro

#Q4
.macro return(%x)
	slti $t0, %x, 0
	beqz $t0, sucesso
	
	add $a0, $zero, %x
	li $v0, 17
	syscall
	
	sucesso:
		done
.end_macro

#Q5
.macro load_var(%carregamento, %reg)
	la $t0, %carregamento	# carrega o endereco de carregamento em $t0
	lw %reg, 0($t0)		# carrega o valor de carregamento em $a0
.end_macro

.macro store_var(%armazenamento, %reg)
	la $t0, %armazenamento	# carrega o endereco de armazenamento em $t0
	sw %reg, 0($t0)		# armazena o valor
.end_macro