#include "HelloWorld.h"

/*
 * Class:     HelloWorld
 * Method:    testSum
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_HelloWorld_testSum
  (JNIEnv *env, jobject thisobj, jint arg0)
{
	jint i;
	jint sum = 0;
	for (i = 0; i < arg0; i++)
		sum += i;
	return sum;
}

