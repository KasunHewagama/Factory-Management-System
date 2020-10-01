function changeType(){

    if(!(registerForm.inputDesig.options[0].selected || registerForm.inputDesig.options[1].selected)){
        document.getElementById('inputType').selectedIndex = 0;
        registerForm.inputType.disabled = true;
    }
    else
    {
        registerForm.inputType.disabled = false;
    }
 
}

function changeDesig(){
    
    if(registerForm.inputType.options[1].selected || registerForm.inputType.options[2].selected)
    {
        document.getElementById('inputDesig').selectedIndex = 1;

    }
}