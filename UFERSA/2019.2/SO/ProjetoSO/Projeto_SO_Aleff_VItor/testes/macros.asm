.data
	errorString: .asciiz "Erro! numero negativo"

.text

.macro SyscallFork(%a0) # criar processo
	li $v0, 19 # load number syscall
	la $a0, %a0
	syscall
.end_macro

.macro SyscallFork(%a0, %p)
	li $v0, 19 # load number syscall
	la $a0, %a0
	la $v1 , %p
	syscall
.end_macro

.macro SyscallProcessChange 
	li $v0, 20
	syscall
.end_macro

.macro SyscallProcessTerminate
	li $v0, 21
	syscall
.end_macro

.macro done #finalizar programa
	li $v0, 10
	syscall	
.end_macro

.macro print_int #imprimir inteiro
      li $v0, 1		#imprimir inteiro
      syscall
      jr $ra	
.end_macro


.macro print_char #imprimir caracter
	li $v0, 11
	syscall
	jr $ra
.end_macro

.macro print_string #imprimir 
	li $v0, 4
	syscall
	jr $ra
.end_macro

.macro read_int #leitura de inteiro
	addi $sp, $sp, -4
        sw $ra, 0($sp)

	li $v0, 5
	syscall
	jal return
	
	lw $ra, 0($sp) # restore $ra register 
	addi $sp, $sp, 4
	
	jr $ra
.end_macro

.macro read_char #leitura de inteiro
	li $v0, 12
	syscall
	jr $ra
.end_macro

.macro read_string #leitura de string
	li $v0, 8 
	syscall
	jr $ra
.end_macro

.macro return 
	blt $v0, 0, exit2 # compare if number is less than 0
	jr $ra
	#jal done # return to the end of program? this doesn't make sense 
.end_macro


.macro exit2 	
	la $a0, errorString # load adress message
	jal print_string # show error message
	jal done # stop program 

.end_macro

.macro load_var # manipulate variables
	lw $v0, 0($a0) # carrega o valor de a1(endereco da label) em v0
	jr $ra
.end_macro

.macro store_var # manipulate variables
	sw $a0, 0($v0) 
	jr $ra
.end_macro
