def validate(passphrase):
    phrases = passphrase.split()

    if len(phrases) != len(set(phrases)):
        return False

    for phrase in phrases:
        for phrase1 in phrases:
            if phrase != phrase1 and sorted(phrase) == sorted(phrase1):
                return False

    return True


def main():
    valid = 0
    passes = """abcde fghij
    abcde xyz ecdab
    a ab abc abd abf abj
    iiii oiii ooii oooi oooo
    oiii ioii iioi iiio"""

    for passphrase in passes.splitlines():
        if validate(passphrase):
            valid += 1

    print(valid)


main()
