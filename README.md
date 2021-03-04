# MusicMashup API service
## How to build and run the service
**Using Spring Boot application**
1. Clone this project into your current working directory
2. In the root of the project, run the following command in the terminal:

        ./gradlew bootRun
        
3. Open a web browser and navigate to http://localhost:8080/mbid/{mbid} where {mbid} is the MBID for which you want to retrieve information regarding artist and albums. <br><br>For example, if the mbid = 5b11f4ce-a62d-471e-81fc-a69a8278c7da, navigate to the following:
        http://localhost:8080/mbid/5b11f4ce-a62d-471e-81fc-a69a8278c7da

**Using executable jar**
1. Clone this project into your current working directory
2. In the root of the project, run the following command in the terminal:

        java -jar build/libs/mashup-rest-service-0.0.1-SNAPSHOT.jar
       
3. Open a web browser and navigate to http://localhost:8080/mbid/{mbid} where {mbid} is the MBID for which you want to retrieve information regarding artist and albums. <br><br>For example, if the mbid = 5b11f4ce-a62d-471e-81fc-a69a8278c7da, navigate to the following:
           http://localhost:8080/mbid/5b11f4ce-a62d-471e-81fc-a69a8278c7da
           
## Comments on the solution
#### Example of output
The API retrieves mbid, and the id and title of each album belonging to the corresponding artist. Description and image is empty in the current solution due to some errors that I did not have the time to address.

        {
            "mbid":"5b11f4ce-a62d-471e-81fc-a69a8278c7da", 
            "description":" ",
            "albums":[
                {"id":"f1afec0b-26dd-3db5-9aa1-c91229a74a24",
                "title":"Bleach",
                "image":""
                },
                more albums...
             ]
        }


#### Not addressed in this solution
- Specific error handling based on HTTP responses. (Spring WebClient's function retrieve() is used instead of the functions exchange() or exchangeToMono() which enable more control)
- Cache Management (which could be used to address performance and speed)

#### Prepared for
- The integration with the Wikidata API and Wikipedia API.
- The integration with the CoverArtArchive API

#### Other comments
- In the current solution, most of the functionality in the class MashupClient is located in getArtistInfoByMbid(). This functionality should be divided into several different functions. 
- The code is not documented enough (due to limited amount of time to work on the task)

#### Issues
- Errors with the action "wbgetentities" for the Wikidata API. Due to these errors, the "sitelinks" for "enwiki" containing the "title" to use in a Wikipedia API request, is not included in this solution.
- Errors due to not finding the right paths and objects in the responses from external APIs have resulted in a solution without a working API request to the Wikidata API  
- Errors indicating that the response from CoverArtArchive API is of incorrect format, therefore not retrieving any image-urls. 