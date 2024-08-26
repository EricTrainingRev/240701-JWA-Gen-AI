import { Directive, HostBinding } from '@angular/core';

// THIS NEEDS WORK

@Directive({
  selector: '[appBoxStyling]'
})
export class BoxStylingDirective {

  @HostBinding('style.border')
  borderSize : string = "1px solid black";

  constructor() { }

}
