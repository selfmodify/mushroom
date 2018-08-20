# Given an encoding scheme (1=a, 2=b,...,26=z) and an input integer as string,
# return number of ways in which it could be encoded.

encmap = {
    '1': 'a', '2': 'b', '3': 'c', '4': 'd',  '5': 'e', '6': 'f', '7': 'g', '8': 'h',
    '9': 'i', '10': 'j', '11': 'k', '12': 'l', '13': 'm', '14': 'n', '15': 'o', '16': 'p',
    '17': 'q', '18': 'r', '19': 's', '20': 't', '21': 'u', '22': 'v', '23': 'w', '24': 'x', '25': 'y',  '26': 'z',
}


def doencode_rec(num, pos, ans):
    if pos >= len(num):
        print(ans)
        return
    x1 = num[pos]
    enc_x1 = encmap[x1]
    doencode_rec(num, pos+1, ans + enc_x1)

    if pos+1 < len(num):
        x2 = num[pos] + num[pos+1]
        if x2 in encmap:
            enc_x2 = encmap[x2]
            doencode_rec(num, pos+2, ans + enc_x2)


def doencode(num):
    print('Encoding for ', num, 'are')
    doencode_rec(num, 0, '')


doencode('21')
doencode('274')
doencode('214')
