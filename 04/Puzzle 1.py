def validate(passphrase):
    phrases = passphrase.split()
    return len(phrases) == len(set(phrases))


def main():
    valid = 0
    passes = """aa bb cc dd ee
    aa bb cc dd aa
    aa bb cc dd aaa"""

    for passphrase in passes.splitlines():
        if validate(passphrase):
            valid += 1

    print(valid)

main()
