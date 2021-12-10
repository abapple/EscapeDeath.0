In this program, the user will find themselves trapped in a haunted mansion where they must escape by solving puzzles and mini-games as they travel through 3 featured spaces in the building. In addition, the user can ask for hints which are pulled from a text file to help them with these tasks. The structure of this project was inspired by early 2000’s text based games from our childhood. The following are data structures and techniques featured in this program:

#HashMap
A HashMap is what stores the input of the hint system in the game. This structure was chosen so that hints could be organized by not only the level of the hint (ranging from vague to explicit) but for what puzzle each group of hints applied to. For example, if a player needed a hint for the morse puzzle the program would access the respective hints and retrieve the exact hint they need depending on how many they have already used (they have a total of 3 for each puzzle). A HashMap is also used in the minigame Mystery Game of which 4 different maze paths are stored in a HashMap. The keys are integers 1 through 4, and a simple random number generator decides which path the maze will implement for that round. 

#Queue
This structure is featured in the Library Book puzzle where the user must put the books in a specific order on the shelf to find a secret message to help them leave. Queue was seen to be the best choice for storing the user’s choices as it is a FIFO structure. This meant that the order the items were put into the structure was the order they could be taken out, which was helpful when trying to determine if the user’s choices resulted in the correct order needed for the secret word as in English words are written left to right.

#Stack
This data structure is featured in the Black Jack Game to hold the cards in the hand of the dealer and the user and aiding in keeping track of their totals (total < or >  21). From a programmer’s view, this added ease to the organization and use of data since it is a LIFO structure. It made accessing the most recent card in the hand more convenient, so the choice of a Stack made sense since the programmer was aware going in how they wanted to use the data collected.

#Recursion
A recursive method is utilized in the Never Ending Hallway to create the effect of endlessly looping within a space for the user (and from a technical standpoint). Upon entering the hallway, a random amount of turns is generated that places them somewhere in the infinite space. By taking a left turn, the number goes down while turning right increases it. The base case is hidden from them, and they need to find what it is in order to finally discover the exit. 
