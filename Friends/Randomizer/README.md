Program Name:	Randomizer

Function:	    This program is a two step program. It will utilize two python
		        scripts to perform its task. The first script, parse_engine.py,
		        will parse input from the command line and store it into a text
		        file, parsed_input.txt. The second script, random_function.py,
		        will take input from the text file and select a random element
		        from the set of inputs to be outputted to the console.

Constraints:    The text file, parsed_input.txt, will contain a maximum of 20
                inputs. The parse engine will only accept the first 20 inputs
                from the command line and ignore any further arguments. The text
                file will contain each input separated by new lines.

Output:		    A single element from a list of inputs.
