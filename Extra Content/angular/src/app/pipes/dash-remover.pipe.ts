import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'dashRemover'
})
export class DashRemoverPipe implements PipeTransform {

  transform(value: string, ...args: any[]): string {
    let words : string[] = value.trim().split("-");
    if (words.length === 1){
      return words[0];
    } else {
      return words.join(" ");
    }


  }

}
