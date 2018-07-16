## Commands

The bot is a general purpose tracker for all types of robots. You can use it to track any post on any of the sites (meta sites included). The main command which can be used to start reporting posts is the `track` command. It can be invoked in the following manner

     @Boson track sitename trackingType frequency

The complete help and usage of the track command is: 



    usage: track [-f [{REPUTATION,LENGTH,USER_ID,POST_ID,TAG}]] [-h]
                 [-n [NAME]] [-p [{ONE_BOX}]] [-r [ROOM]]
                 [-t [{STACK_OVERFLOW,STACK_EXCHANGE}]] [-v [VALUE]] site type
                 frequency
    
    Argument Parser for the bot.
    
    positional arguments:
      site                   Site where the bot has to be run
      type                   Type  of  the  tracker  needed.   Can  be  one  of
                             {questions,answers,comments,posts,tags}
      frequency              Frequency of the tracker in seconds
    
    named arguments:
      -f [{REPUTATION,LENGTH,USER_ID,POST_ID,TAG}], --filter [{REPUTATION,LENGTH,USER_ID,POST_ID,TAG}]
                             Set the filters used by the bot
      -h, --help             Display this message
      -n [NAME], --name [NAME]
                             Give a name to  your  bot  (we  will generate a 10
                             digit value, if you don't)
      -p [{ONE_BOX}], --printer [{ONE_BOX}]
                             Set the printer to be used by the bot
      -r [ROOM], --room [ROOM]
                             Set the room where it has to run
      -t [{STACK_OVERFLOW,STACK_EXCHANGE}], --host [{STACK_OVERFLOW,STACK_EXCHANGE}]
                             Set the chat host of that room
      -v [VALUE], --value [VALUE]
                             Set the value needed for  the filter, depending on
                             it's type
                             

### Example Usage

Thanks to it being very generic, Boson usually overwhelms users with it's available options, but thankfully most of them are optional. Few sample trackers are:

 - Tracking all the new questions posted on Stack Overflow every 3 minutes (180 seconds)
  
       @Boson track stackoverflow questions 180
       
 - Tracking the next comment on the highest voted post  on the workplace
 
       @Boson track comments 500 -f POST_ID -v 93696
 
 - Tracking all the answers posted by Shog9 on Meta Stack Exchange
 
       @Boson track meta answers 3000 -f USER_ID -v 811 
      
 - Tracking the next featured meta post, in a private room
 
       @Boson track meta questions 1000 -f TAG -v featured -r 54445 --host STACK_EXCHANGE
       
 - Tracking recently created tags on interpersonal skills
 
       @Boson track interpersonal tags 21600
       

### Available Content types


Boson is still under active development. As of now, the available content types are:

 1. Questions
 2. Answers
 3. Comments 
 4. Posts
 5. Tags
 
 ### Available Printers
 
 The available printers are:
 
 1. Generic Printer (which is the default option)
 2. One box printer (which one boxes the post by linking it in a separate message)
 
 ### Available Filters
 
 The available filters are:
 
 1. Reputation
 2. Length
 3. PostID
 4. UserID
 5. Tag