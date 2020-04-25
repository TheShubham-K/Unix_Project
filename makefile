all: README.md

README.md:
	echo '# Guessing Game Bash Script for Unix Workbench\n' > README.md
	echo '* This is a guessing the correct number og files in a directory game in which users are asked to guess the current number of files in the directory and if the guess is wrong then try again' >> README.md
	echo '* If the user guesses the right number of file then the game terminates.' >> README.md
	echo '* This Make File was ran at: $(shell date +%Y-%m-%d:%H:%M:%S)\n' >> README.md
	echo '* There were $(shell wc -l < guessinggame.sh) lines in guessinggame.sh\n' >> README.md
 
