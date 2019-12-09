### Inspiration
Our inspiration comes from our daily life experience. When your friend or your idol posts a pretty fancy landmark picture on Instagram or Facebook but you have no idea where that is, you can just snap it and our smart app will do the rest of research for you, offering you an optimal instant flight and travel plan.

### What it does
This app takes in a local photo or screenshot and analyzes it with Microsoft's intelligent Azure, basically the cognitive services area focusing on the Computer Vision API. When first open the app, there will be a Welcome page, then the user can click the button at the bottom to start analyzing the picture. For now we just set 4 default local picture in the drawer folder and can be processed in the app in random order. After the implementation of Microsoft API, the picture will be processed into a URL, then after some modification of the Microsoft result our app can get the specific landmark name and use Google Map API to generate the location, then the destination city. After that, we will immediately provide you with the optimal flight and travel plan via access to Expedia.com. In general, you just give us a picture, and we can provide you with the specific flight and travel plan.

### How we built it
- Tool: Java, Android Studio, APIs from Microsoft and Google Map
- Brainstorm: Spent whole Friday night to come up with ideas and get our detailed final plan
- teamwork: Clear task distribution among 4 members according to each one's skill sets
- Persistence: Always be on time and willing to solve problems for other team members; Work until last several hours and never compromise in front of challenges
- Passion: Hackathon is a great physical and mental challenge, but we still enjoy the whole process and have a great time due to our passion and love to programming and problem-solving.

### Challenges we ran into
- Time limitation
- Learning to use different APIs in a relatively short time
- Continuous modification and plan adjustment during our process
- Merge of everyone's code into one integral app without losing any optimal functions

### Accomplishments that we're proud of
We made it! It's our first time to complete such a big hackathon!
We made a fully-functioning app that can help user save time and have better traveling experience
The app accomplishes an intelligent and automatic process from the initial input to the final output without too much user intervention.

### What we learned
- Importance of teamwork
- After finishing this app, we all have a better understanding of the data and visual flow inside an application
- Developed better Front End(UI) and backEnd(API) skills, especially how to combine those two together.

### What's next for Snap-and-Fly
Due to time limitation, we still have a lot of glitchy mistakes and edge cases that need further optimization. Our future plan is to allow the users to upload and analyze local pictures they saved in the gallery or photos, as well as getting more thorough access to google/Wikipedia image API and help our search more accurate and reliable.

Please see more details here: https://devpost.com/software/snap-and-fly#updates
