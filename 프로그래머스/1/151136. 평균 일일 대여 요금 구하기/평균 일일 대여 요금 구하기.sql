SELECT round(avg(daily_fee), 0) average_fee
from CAR_RENTAL_COMPANY_CAR
group by car_type
having car_type = 'SUV';