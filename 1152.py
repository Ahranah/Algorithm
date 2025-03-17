sentences = input().strip()
sentences = sentences
num = 0

if len(sentences) == 0:
    print (num)

else:
        for char in sentences:
            if char == ' ':
                num+= 1

        print ( num +1 )