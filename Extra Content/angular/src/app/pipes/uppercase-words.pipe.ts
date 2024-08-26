import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'uppercaseWords'
})
export class UppercaseWordsPipe implements PipeTransform {

  transform(value: string, ...args: any[]): string {
    let words : string[] = value.split(" ");
    for(let x = 0; x < words.length; x++){
      let a = words[x].charAt(0).toUpperCase()
      let b = words[x].slice(1);
      words[x] = a + b;
    }
    return words.join(" ");
  }

}
