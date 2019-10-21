package com.ifmo.lesson2;

public class LuckyTickets {
    /*
    В городе N проезд в трамвае осуществляется по бумажным отрывным билетам. Каждую
    неделю трамвайное депо заказывает в местной типографии рулон билетов с номерами от
    000001 до 999999. «Счастливым» считается билетик у которого сумма первых трёх цифр
    номера равна сумме последних трёх цифр, как, например, в билетах с номерами 003102 или
    567576. Трамвайное депо решило подарить сувенир обладателю каждого счастливого билета
    и теперь раздумывает, как много сувениров потребуется. С помощью программы подсчитайте
    сколько счастливых билетов в одном рулоне?
     */
    public static void main(String[] args) {
        System.out.println(luckyTickets());
    }

    public static int luckyTickets() {
        int count = 0;
        for(int i=1001;i<1000000;i++){
            int     i1=i/100000%10,
                    i2=i/10000%10,
                    i3=i/1000%10,
                    i4=i/100%10,
                    i5=i/10%10,
                    i6=i%10;
            if((i1+i2+i3)==(i4+i5+i6)){
                count++;
            }
        }
            return count;

    }
}