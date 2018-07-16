# Commands

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
                             

## Example Usage

Thanks to it being very generic, Boson usually overwhelms users with it's available options, but thankfully most of them are optional. Few sample trackers are:

 - Tracking all the new questions posted on Stack Overflow every 3 minutes (180 seconds)
  
       @Boson track stackoverflow questions 180
       
 - Tracking the next comment on question id 93696 on the workplace (highest voted post on that site)
 
       @Boson track comments 500 -f POST_ID -v 93696
 
 - Tracking all the answers posted by Shog9 (user 811) on Meta Stack Exchange
 
       @Boson track meta answers 3000 -f USER_ID -v 811 
      
 - Tracking the next featured meta post, in a private room
 
       @Boson track meta questions 1000 -f TAG -v featured -r 54445 --host STACK_EXCHANGE
       
 - Tracking recently created tags on interpersonal skills
 
       @Boson track interpersonal tags 21600
       

## Content types


Boson is still under active development. As of now, the available content types are:

 1. Questions
 2. Answers
 3. Comments 
 4. Posts
 5. Tags
 
 ## Printers
 
 The available printers are:
 
 1. Generic Printer (which is the default option)
 2. One box printer (which one boxes the post by linking it in a separate message)
 
 ## Filters
  
  
 ### Available Filters
 
 The available filters (and the expected values) are:
 
 1. Reputation  (The reputation of the poster at which it should be filtered. Should be a number)
 2. Length (The length of the content at which it should be filtered. Should be a number)
 3. PostID (The ID of the post on which you need to track comments. Should be a number)
 4. UserID (The ID of the user whose posts you need to track. Should be a number)
 5. Tag (The name of the tag which you need to filter the questions. Should be a ; separated list of tag names)
 
 ### Using filters to obtain the data you need
 
 The filters are designed in such a way that you can choose one of them (using `-f` argument) and supply a value (using the `-v` argument), which you use to filter the data you receive. So to get the comments by low reputation users, you can use:
 
      @Boson track stackoverflow comments 100 -f REPUTATION -v -50
      
  Notice the "`-50`" argument supplied as value. When you need something to filter content below the value, use the negative sign. Therefore to track the comments by users with more than 50 reputation, you would be using the same command, excpet with `-v 50`. 
  
  You can add multiple requests as well, for example: 
  
      @Boson track stackoverflow comments 100 -f REPUTATION LENGTH -v -50 -50
      
  would track all the comments with a length lesser than 50 characters and are posted by users below 50 reputation. 
 
