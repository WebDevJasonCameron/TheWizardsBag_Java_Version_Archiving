# Notes from AI

## 2024 01 01 | Easier than If
Me:
> User
I have a list of words with corresponding numbers.  If I input a word and it matches one of the words in the list, the corresponding number needs to be returned.  I'm doing this in python.  Can you help me write if statement to do this?  I also need all the words in the list to have lowercase letters.  Here is my list and their related numbers:

    5	"Banishment"
    8	"Buff"
    9	"Charmed"
    10	"Combat"
    11	"Communication"
    12	"Compulsion"
    15	"Control"
    16	"Creation"
    18	"Damage"
    19	"Debuf"
    20	"Deception"
    21	"Detection"
    23	"Dunamancy"
    26	"Environment"
    28	"Exploration"
    33	"Foreknowledge"
    34	"Foresight"
    36	"Healing"
    44	"Movement"
    47	"Negation"
    52	"Sangromancy"
    55	"Scrying"
    57	"Shapechanging"
    58	"Social"
    59	"Special"
    61	"Summoning"
    66	"Teleportation"

Gpt:
>Certainly! You can use an `if` statement or a dictionary to achieve this in Python. Here's an example using an `if` statement:
>
>```python
>def get_number_for_word(word):
>    # Convert the input word to lowercase
>    lowercased_word = word.lower()
>
>    # List of words and their corresponding numbers
>    word_number_mapping = {
>        "banishment": 5,
>        "buff": 8,
>        "charmed": 9,
>        "combat": 10,
>        "communication": 11,
>        "compulsion": 12,
>        "control": 15,
>        "creation": 16,
>        "damage": 18,
>        "debuf": 19,
>        "deception": 20,
>        "detection": 21,
>        "dunamancy": 23,
>        "environment": 26,
>        "exploration": 28,
>        "foreknowledge": 33,
>        "foresight": 34,
>        "healing": 36,
>        "movement": 44,
>        "negation": 47,
>        "sangromancy": 52,
>        "scrying": 55,
>        "shapechanging": 57,
>        "social": 58,
>        "special": 59,
>        "summoning": 61,
>        "teleportation": 66,
>    }
>
>    # Check if the lowercased_word is in the dictionary
>    if lowercased_word in word_number_mapping:
>        return word_number_mapping[lowercased_word]
>    else:
>        return None  # Return None if the word is not in the list
>
># Example usage:
>input_word = input("Enter a word: ")
>result = get_number_for_word(input_word)
>if result is not None:
>    print(f"The corresponding number for '{input_word}' is {result}.")
>else:
>    print(f"'{input_word}' is not in the list.")
>```
>
>This function, `get_number_for_word`, takes an input word, converts it to lowercase, and checks if it's in the dictionary. If it is, it returns the corresponding number; otherwise, it returns `None`.