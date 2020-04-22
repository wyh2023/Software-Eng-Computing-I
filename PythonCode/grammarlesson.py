def isPetyaLanguage():
    sentence = []
    flg = 0

    def judge(voc):
        if voc[-4:] == 'lios':
            sentence.append(['positive', 'adj'])
        elif voc[-5:] == 'liala':
            sentence.append(['negative', 'adj'])
        elif voc[-3:] == 'etr':
            sentence.append(['positive', 'n'])
        elif voc[-4:] == 'etra':
            sentence.append(['negative', 'n'])
        elif voc[-6:] == 'initis':
            sentence.append(['positive', 'v'])
        elif voc[-6:] == 'inites':
            sentence.append(['negative', 'v'])
        else:
            sentence.append('wrong')

    words = input().split(' ')
    for word in words:
        judge(word)
    sentence_prop = []
    sentence_attr = []
    for i in sentence:
        sentence_prop.append(i[0])
        sentence_attr.append(i[1])
    if 'n' not in sentence_attr:
        flg = 1
    if sentence_attr.count('n') > 1:
        flg = 1
    attr_str = ''.join(sentence_attr)
    judge_attr = attr_str.split('n')

    if 'wrong' in sentence:
        flg = 1
    elif len(sentence) == 1:
        flg = 0
    else:
        if len(judge_attr) == 2:
            judge_attr_a = judge_attr[0].split('adj')
            for i in judge_attr_a:
                if i != '':
                    flg = 1

            judge_attr_v = judge_attr[1].split('v')
            for i in judge_attr_v:
                if i != '':
                    flg = 1

            flg_prop = sentence_prop[0]
            for i in sentence_prop:
                if i != flg_prop:
                    flg = 1

            if sentence_attr.count('n') > 1:
                flg = 1

    if flg == 1:
        print('NO')
    else:
        print('YES')

    return


if __name__ == "__main__":
    isPetyaLanguage()
