#include <stdio.h>
#include <stdlib.h>

void combinacaoLinear(){
int numero1;
int numero2;
int combinacao;
int x2 = 1;
int y2 = 0;
int resto;
int y1 = 1;
int x1 = 0;
int quociente;
printf("Digite o primeiro numero:\n");
scanf("%d",&numero1);
printf("Digite o segundo numero:\n");
scanf("%d",&numero2);
while(numero2 !=0){
resto = (numero1 % numero2);
quociente = (numero1-(resto*numero2));
int x = (x2-(resto*x1));
int y = (y2-(resto*y1));
numero1 = numero2;
numero2 = quociente;
x2 = x1;
x1 = x;
y2 = y1;
y1 = y;
combinacao = numero1;
x = x2;
y = y2;
printf("Combinacao:%d\n",combinacao);
printf("x:%d\n",x);
printf("y:%d\n",y);
}
}
int main(){
combinacaoLinear();
return 0;
}

