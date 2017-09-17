   Caution!!! 

A deprecated method( or poor method) which could cause logical rotations. you may view [EventBus](https://github.com/search?utf8=%E2%9C%93&q=eventbus&type) instand.

   # PutExtraBack

A simple demo which send message through activities (more than two) by intent.

 Here cames a question when I first tried to send some values through activities: I have three activities, and some values need to be passed through actvity and processed. But didn't wanna synchronize them. So I thought hey why wound I put them into intent. Then here we are.
 
   # Resume
 
  In order to get the values back after another actvity process them, method startActivityForResult will be needed, which means that onActivityResult should be overridden. The activity need a result back, so the second activity won't finish if the third activity is started and method onBackPress should be overridden. 
  I want third activity can back to the first activity directly， so I tried to override onActvityResult in the second activity , and it work just fine:
  
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        Intent feedback = new Intent(Page2Activity.this,Page1Activity.class);
        feedback.putExtra("source_position",data.getIntExtra("source_position",0));
        setResult(RESULTCODE_FROM_PAGE3,feedback);
        finish();
    }
 I have setup some flag to tell the current activity where the message came from. It may be useful in a real application, but I don't need the flag here. 
