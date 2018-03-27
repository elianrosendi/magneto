# Try it!
POST https://magneto-199307.appspot.com/mutant

  "dna": [
    "ATACGA",
    "TTACGA",
    "ATCCTT",
    "TTACGT",
    "ATACGA",
    "ATACGT"
  ]

# Instructions to run locally:

 - mvn package (to generate jar file)
 - docker build -t magneto .
 - docker-compose up
