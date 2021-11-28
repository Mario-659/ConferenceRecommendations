import random, string

NUM_OF_UNIQUE_ATTR = 30
NUM_OF_PARTICIPANTS = 100

allAttributes = []
for _ in range(NUM_OF_UNIQUE_ATTR):
    allAttributes.append(''.join(random.choices(string.ascii_letters, k=5)))

text = ''

for x in range(NUM_OF_PARTICIPANTS):
    numOfAttr = random.randint(1, 5)
    numOfWantedAttr = random.randint(1, 5)
    attr = random.choices(allAttributes, k=numOfAttr)
    wantedAttr = random.choices(allAttributes, k=numOfWantedAttr)

    attr = ','.join(attr).strip(' ').strip('\'')
    wantedAttr = ','.join(wantedAttr).strip(' ').strip('\'')
    line = '%d\t%s\t%s\n' %(x+1,attr, wantedAttr)
    text += line

file = open('randomInput.txt', 'w+')
file.write(text)
file.close