# EncryptionCLI 2.0

# Whats new?
  Added new algorithm UNISHIFT

# About
Encrypts a sequence of characters depending on the key and algorithm specified

# Parameters
--data  sequence of characters to be encrypted or decrypted

--key   no. of steps every characater moves

--alg   specifiy what algorithm to use (SHIFT, UNICODE, UNISHIFT)

--in    location of the file instead of --data

--out   location where the output is stored from --in, if not specified the result will be printed

# How to run

# Run using java tool
 I. Locate the jar file at /build/libs
 
 II.Run "java -jar encrpytion-tool-2.0.jar -parameters..." in the command line

# Run using gradle
 I. Go to the root folder
 
 II. Run "gradlew run --args="'--parameters'"" in the command line
