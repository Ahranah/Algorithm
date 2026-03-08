SELECT animal_id, name, 
(case 
 when substr(sex_upon_intake, 0, instr(sex_upon_intake, ' ')-1) in ('Neutered' , 'Spayed' ) then 'O'
 else 'X'
 end) as 중성화
 from animal_ins
 order by animal_id