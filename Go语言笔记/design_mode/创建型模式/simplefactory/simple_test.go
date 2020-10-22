package simplefactory

import (
	"fmt"
	"testing"
)

func TestType1(t *testing.T){
	api := NewApi(1)
	say := api.Say("tome")
	fmt.Println(say)
}
