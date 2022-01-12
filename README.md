<br />
<div align="center">
  <a href="https://github.com/diogomarante/premium-challenge">
    <img src="ash.png" alt="Ash" width="80" height="80">
  </a>

  <h3 align="center">Pokemon Premium</h3>

  <p align="center">
    <br>
    An awesome challenge!
    <br/>
    <a href="https://pokemon-premium.herokuapp.com"><strong>View demo »</strong></a>
  </p>
</div>

### Installation

Download or clone the repo
   ```sh
   git clone https://github.com/diogomarante/premium-challenge.git
   ```

<p align="right">(<a href="#top">back to top</a>)</p>

### Compile and run

1. Compile
   ```sh
   javac PokemonPremium.java
   ```
2. Run 
   Option 1. Run without files. This will enter a loop where the user enters the input and prints the output to the console. 
   ```sh
   java PokemonPremium
   ```
   Option 2. Run with input file only. If you want to run a set of inputs you can create a .txt file and pass it as the first argument after the file to run.
   Example of usage for the given input.txt file:
   ```sh
   java PokemonPremium input
   ```
   Option 3. Run with input and output file. If you want to compare the program outputs with another file just put the name of the .txt file without the extension after the input file.
   Example of usage for the given input.txt and output.txt files:
   ```sh
   java PokemonPremium input output
   ```
   
   Note: the .txt files must have 1 input/output value per line without additional characters. The lines of the input file and output files must match.

<p align="right">(<a href="#top">back to top</a>)</p>

## Implementation

Here is how my solution works:

SETUP
1. Read the input
2. Count how many times each direction appears in the input
3. Create a (E + O + 1) x (N + S + 1) grid (SafariZone) where N,S,E,O are the directions count from the input
4. Populate the grid with nodes (Node) and create connections between orthogonally adjacent nodes
5. Create a player with 1 pokemon caught and starting at the node [O, N] to make sure edges are not crossed

EXECUTION LOOP
1. Move player in the next direction ( if direction is N , player current node will be currentNode -> N )
2. Increment the pokemon count by 1 if the visited node still has a pokemon and remove it


_For an interactive visualization of the implemetation (in a 9x9 grid) please refer to [PokemonPremium](https://pokemon-premium.herokuapp.com/)_

<p align="right">(<a href="#top">back to top</a>)</p>
