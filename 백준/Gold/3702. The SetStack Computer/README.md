# [Gold I] The SetStack Computer - 3702 

[문제 링크](https://www.acmicpc.net/problem/3702) 

### 성능 요약

메모리: 70732 KB, 시간: 400 ms

### 분류

비트 집합, 자료 구조, 구현, 스택, 트리, 트리 동형 사상

### 제출 일자

2025년 10월 30일 21:48:43

### 문제 설명

<p>Background from Wikipedia: “Set theory is a branch of mathematics created principally by the German mathematician Georg Cantor at the end of the 19th century. Initially controversial, set theory has come to play the role of a foundational theory in modern mathematics, in the sense of a theory invoked to justify assumptions made in mathematics concerning the existence of mathematical objects (such as numbers or functions) and their properties. Formal versions of set theory also have a foundational role to play as specifying a theoretical ideal of mathematical rigor in proofs.”</p>

<p>Given this importance of sets, being the basis of mathematics, a set of eccentric theorist set off to construct a supercomputer operating on sets instead of numbers. The initial SetStack Alpha is under construction, and they need you to simulate it in order to verify the operation of the prototype.</p>

<p>The computer operates on a single stack of sets, which is initially empty. After each operation, the cardinality of the topmost set on the stack is output. The cardinality of a set S is denoted |S| and is the number of elements in S. The instruction set of the SetStack Alpha is <code>PUSH</code>, <code>DUP</code>, <code>UNION</code>, <code>INTERSECT</code>, and <code>ADD</code>.</p>

<ul>
	<li><code>PUSH</code> will push the empty set {} on the stack.</li>
	<li><code>DUP</code> will duplicate the topmost set (pop the stack, and then push that set on the stack twice).</li>
	<li><code>UNION</code> will pop the stack twice and then push the union of the two sets on the stack.</li>
	<li><code>INTERSECT</code> will pop the stack twice and then push the intersection of the two sets on the stack.</li>
	<li><code>ADD</code> will pop the stack twice, add the first set to the second one, and then push the resulting set on the stack.</li>
</ul>

<p>For illustration purposes, assume that the topmost element of the stack is</p>

<p style="text-align: center;">A = {{}, {{}}}</p>

<p>and that the next one is</p>

<p style="text-align: center;">B = {{}, {{{}}}}.</p>

<p>For these sets, we have |A| = 2 and |B| = 2. Then:</p>

<ul>
	<li><code>UNION</code> would result in the set { {}, {{}}, {{{}}} }. The output is 3.</li>
	<li><code>INTERSECT</code> would result in the set { {} }. The output is 1.</li>
	<li><code>ADD</code> would result in the set { {}, {{{}}}, {{},{{}}} }. The output is 3.</li>
</ul>

### 입력 

 <p>An integer 0 ≤ T ≤ 5 on the first line gives the cardinality of the set of test cases. The first line of each test case contains the number of operations 0 ≤ N ≤ 2 000. Then follow N lines each containing one of the five commands. It is guaranteed that the SetStack computer can execute all the commands in the sequence without ever popping an empty stack.</p>

### 출력 

 <p>For each operation specified in the input, there will be one line of output consisting of a single integer. This integer is the cardinality of the topmost element of the stack after the corresponding command has executed. After each test case there will be a line with *** (three asterisks).</p>

